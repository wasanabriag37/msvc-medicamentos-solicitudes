package com.nuevaeps.msvc_request_medicine.application.intput;

import java.util.List;

import org.springframework.data.domain.Page;

import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.RequestMedicine;
import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.ResponseMedicine;

public interface MedicineUseCase {
    ResponseMedicine create(RequestMedicine requestMedicine);
    List<ResponseMedicine> getlAll();
    Page<ResponseMedicine> getPag(String name, Long code, Boolean coverage, Integer cantRecords, Integer pagCurrent);
}
