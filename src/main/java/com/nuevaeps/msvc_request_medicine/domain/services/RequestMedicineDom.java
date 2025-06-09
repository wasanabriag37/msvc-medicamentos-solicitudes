package com.nuevaeps.msvc_request_medicine.domain.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nuevaeps.msvc_request_medicine.domain.models.RequestMedicineModel;
import com.nuevaeps.msvc_request_medicine.domain.ports.in.RequestMedicineIn;
import com.nuevaeps.msvc_request_medicine.domain.ports.out.RequestMedicineOut;
import com.nuevaeps.msvc_request_medicine.domain.rules.PaginatorRule;
import com.nuevaeps.msvc_request_medicine.domain.rules.ValidatePosRule;
import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.FilterRequestMedicine;
import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.ResponseRequestMedicine;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RequestMedicineDom implements RequestMedicineIn {

    private final RequestMedicineOut requestMedicineOut;
    private final ValidatePosRule validatePosRule;
    private final PaginatorRule paginatorRule;
    
    @Override
    public ResponseRequestMedicine createRequest(HttpServletRequest requestHeader, RequestMedicineModel request) {
        validatePosRule.isCoragePos(request.getMedicineId(), request);
        return requestMedicineOut.createRequest(requestHeader, request);
    }

    @Override
    public Page<ResponseRequestMedicine> getPagRequests(FilterRequestMedicine filterRequestMedicine) {
        return requestMedicineOut.getPagRequests(filterRequestMedicine, paginatorRule.getPageable(filterRequestMedicine.getCantRecords(), filterRequestMedicine.getPagCurrent()));
    }

}
