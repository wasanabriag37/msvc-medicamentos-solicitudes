package com.nuevaeps.msvc_request_medicine.infrastruture.output.external.services;

import java.time.Duration;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.nuevaeps.msvc_request_medicine.domain.models.User;
import com.nuevaeps.msvc_request_medicine.infrastruture.output.external.in.UserApi;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserApiService implements UserApi{
    
    private final WebClient webClientUser;

    @Override
    public Set<User> getUsers(Set<Integer> usersIds) {
        String userIdsParam = usersIds.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
            return webClientUser.get()
            .uri(uriBuilder -> uriBuilder
                    .path("/user/v1/getByIds")
                    .queryParam("userIds", userIdsParam)
                    .build())
            .retrieve()
            .bodyToFlux(User.class)
            .collect(Collectors.toSet()) 
            .timeout(Duration.ofSeconds(15))
            .onErrorResume(e -> Mono.just(
                    usersIds.stream()
                            .map(id -> new User(id, null, null, null, null, null))
                            .collect(Collectors.toSet())
            ))
            .block();
    }

}
