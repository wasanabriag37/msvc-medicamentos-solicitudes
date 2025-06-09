package com.nuevaeps.msvc_request_medicine.infrastruture.input.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseDataAddRequestMedicine {
    private Long numberOrder;
    private String address;
    private String phone;
    private String email;
}
