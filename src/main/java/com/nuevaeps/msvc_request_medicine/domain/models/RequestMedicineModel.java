package com.nuevaeps.msvc_request_medicine.domain.models;

import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.ResponseDataAddRequestMedicine;
import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.ResponseMedicine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RequestMedicineModel {
    private int medicineId;
    private ResponseMedicine responseMedicine;
    private ResponseDataAddRequestMedicine dataAddRequestMedicine;
    private User user;
    private Integer amount;
}
