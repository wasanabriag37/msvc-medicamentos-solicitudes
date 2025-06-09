package com.nuevaeps.msvc_request_medicine.domain.ports.out;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nuevaeps.msvc_request_medicine.domain.models.Medicine;
import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.ResponseMedicine;

public interface MedicineOut {
    boolean existsMedicineByname(String name);
    boolean isCoveragePos(int id);
    ResponseMedicine create(Medicine medicine);
    List<ResponseMedicine> getAll();
    Page<ResponseMedicine> getPag(String name, Long code, Boolean coverage, Pageable pageable);
}
