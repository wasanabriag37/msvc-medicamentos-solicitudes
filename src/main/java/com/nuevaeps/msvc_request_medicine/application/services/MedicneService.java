package com.nuevaeps.msvc_request_medicine.application.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nuevaeps.msvc_request_medicine.application.intput.MedicineUseCase;
import com.nuevaeps.msvc_request_medicine.application.mappers.MedicineMapper;
import com.nuevaeps.msvc_request_medicine.domain.ports.in.MedicineIn;
import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.RequestMedicine;
import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.ResponseMedicine;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicneService implements MedicineUseCase {
    
    private final MedicineIn medicineIn;
    private final MedicineMapper medicineMapper;

    @Override
    public ResponseMedicine create(RequestMedicine requestMedicine) {
        return medicineIn.create(medicineMapper.requestMedicineToMedicine(requestMedicine));
    }

    @Override
    public List<ResponseMedicine> getlAll() {
        return medicineIn.getAll();
    }

    @Override
    public Page<ResponseMedicine> getPag(String name, Long code, Boolean coverage, Integer cantRecords, Integer pagCurrent) {
        return medicineIn.getPag(name, code, coverage, cantRecords, pagCurrent);
    }

}
