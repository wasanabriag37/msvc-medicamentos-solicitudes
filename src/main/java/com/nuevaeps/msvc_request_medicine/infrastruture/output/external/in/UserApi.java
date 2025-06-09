package com.nuevaeps.msvc_request_medicine.infrastruture.output.external.in;

import java.util.Set;

import com.nuevaeps.msvc_request_medicine.domain.models.User;

public interface UserApi {
    Set<User> getUsers(Set<Integer> usersIds);
}
