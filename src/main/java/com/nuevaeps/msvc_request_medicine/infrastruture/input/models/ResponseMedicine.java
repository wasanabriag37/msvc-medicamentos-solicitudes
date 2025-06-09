package com.nuevaeps.msvc_request_medicine.infrastruture.input.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseMedicine {
    private int medicineId;
    private Long code;
    private String nameMedicine;
    private boolean coveragePos;
}
