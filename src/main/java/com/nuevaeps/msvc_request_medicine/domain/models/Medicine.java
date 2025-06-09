package com.nuevaeps.msvc_request_medicine.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Medicine {
    private Long code;
    private String nameMedicine;
    private boolean coveragePos;
}
