package com.nuevaeps.msvc_request_medicine.domain.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nuevaeps.msvc_request_medicine.domain.exceptions.ExceptionMedicineDuplicate;
import com.nuevaeps.msvc_request_medicine.domain.models.Medicine;
import com.nuevaeps.msvc_request_medicine.domain.ports.in.MedicineIn;
import com.nuevaeps.msvc_request_medicine.domain.ports.out.MedicineOut;
import com.nuevaeps.msvc_request_medicine.domain.rules.PaginatorRule;
import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.ResponseMedicine;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicineServiceDom implements MedicineIn{
    
    private final MedicineOut medicineOut;
    private final PaginatorRule paginatorRule;
    
    @Override
    public ResponseMedicine create(Medicine medicine) {
        if(medicineOut.existsMedicineByname(medicine.getNameMedicine())) throw new ExceptionMedicineDuplicate();
        return medicineOut.create(medicine);
    }

    @Override
    public List<ResponseMedicine> getAll() {
        return medicineOut.getAll();
    }

    @Override
    public Page<ResponseMedicine> getPag(String name, Long code, Boolean coverage, Integer cantRecords, Integer pagCurrent) {
        return medicineOut.getPag(name, code, coverage, paginatorRule.getPageable(cantRecords, pagCurrent));
    }

}
