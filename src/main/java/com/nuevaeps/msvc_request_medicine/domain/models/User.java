package com.nuevaeps.msvc_request_medicine.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private int userId;
    private String names;
    private String lastNames;
    private String email;
    private Long numberDocument;
    private String phone;
}
