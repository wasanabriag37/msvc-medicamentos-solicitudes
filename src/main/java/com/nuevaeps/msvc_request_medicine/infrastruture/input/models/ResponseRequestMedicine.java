package com.nuevaeps.msvc_request_medicine.infrastruture.input.models;


import com.nuevaeps.msvc_request_medicine.domain.models.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseRequestMedicine {
    private int requestMedicineId;
    private User user;
    private ResponseMedicine medicine;
    private ResponseDataAddRequestMedicine dataAddRequestMedicine;
    private Integer amount;
}
