package com.nuevaeps.msvc_request_medicine.domain.rules;

import org.springframework.stereotype.Service;

import com.nuevaeps.msvc_request_medicine.domain.exceptions.ExceptionDataAddRequestFound;
import com.nuevaeps.msvc_request_medicine.domain.models.RequestMedicineModel;
import com.nuevaeps.msvc_request_medicine.domain.ports.out.MedicineOut;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ValidatePosRule {

    private final MedicineOut medicineOut;

    public void isCoragePos(int medicineId, RequestMedicineModel requestMedicineModel){
        if(!medicineOut.isCoveragePos(medicineId) && requestMedicineModel.getDataAddRequestMedicine() == null) throw new ExceptionDataAddRequestFound();
    }
}
