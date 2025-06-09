package com.nuevaeps.msvc_request_medicine.infrastruture.mappers;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.nuevaeps.msvc_request_medicine.domain.models.User;
import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.ResponseRequestMedicine;
import com.nuevaeps.msvc_request_medicine.infrastruture.output.external.in.UserApi;
import com.nuevaeps.msvc_request_medicine.infrastruture.output.persistence.entities.RequestMedicineEntity;

@Component
public abstract class MapperRequestMedicineInfDecorator implements MapperRequestMedicineInf{

    @Autowired
    @Qualifier("delegate")
    private MapperRequestMedicineInf delegate;

    @Autowired
    private UserApi userApi;

    @Autowired
    private DataAdditionsRequestMapperInf dataAdditionsRequestMapper;

  @Override
    public Set<ResponseRequestMedicine> requestMedicineEntitiesToResponses(Set<RequestMedicineEntity> requestMedicineEntities) {
        Set<Integer> usersIds = requestMedicineEntities.stream()
                .map(RequestMedicineEntity::getUserId)
                .filter(Objects::nonNull)
                .map(Long::intValue)
                .collect(Collectors.toSet());
        Set<User> users = userApi.getUsers(usersIds);
        Map<Integer, User> userMap = users.stream()
                .collect(Collectors.toMap(User::getUserId, user -> user));
        Map<Integer, Integer> requestToUserMap = requestMedicineEntities.stream()
                .filter(entity -> entity.getUserId() != null)
                .collect(Collectors.toMap(
                        RequestMedicineEntity::getRequestMedicineId,
                        entity -> entity.getUserId().intValue(),
                        (existing, replacement) -> existing
                ));
        return requestMedicineEntities.stream()
                .map(entity -> {
                    ResponseRequestMedicine response = enrichWithUser(
                        delegate.requestMedicineEntityToResponseUn(entity), 
                        entity.getRequestMedicineId(), 
                        requestToUserMap, 
                        userMap
                    );
                    if (entity.getDataAdditionsRequest() != null) {
                        response.setDataAddRequestMedicine(
                            dataAdditionsRequestMapper.dataAdditionsRequestEntityToResponse(entity.getDataAdditionsRequest())
                        );
                    }
                    return response;
                })
                .collect(Collectors.toSet());
    }

    private ResponseRequestMedicine enrichWithUser(ResponseRequestMedicine response,
                                                   Integer requestId,
                                                   Map<Integer, Integer> requestToUserMap,
                                                   Map<Integer, User> userMap) {
        Integer userId = requestToUserMap.get(requestId);
        if (userId != null && userMap.containsKey(userId)) {
            response.setUser(userMap.get(userId));
        }
        return response;
    }
}
