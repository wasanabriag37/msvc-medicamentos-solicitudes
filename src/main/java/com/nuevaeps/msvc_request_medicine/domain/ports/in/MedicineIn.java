package com.nuevaeps.msvc_request_medicine.domain.ports.in;

import java.util.List;

import org.springframework.data.domain.Page;

import com.nuevaeps.msvc_request_medicine.domain.models.Medicine;
import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.ResponseMedicine;

public interface MedicineIn {
    ResponseMedicine create(Medicine medicine);
    List<ResponseMedicine> getAll();
    Page<ResponseMedicine> getPag(String name, Long code, Boolean coverage, Integer cantRecords, Integer pagCurrent);
}
