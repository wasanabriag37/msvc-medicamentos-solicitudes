package com.nuevaeps.msvc_request_medicine.application.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nuevaeps.msvc_request_medicine.application.intput.RequestMedicineUseCase;
import com.nuevaeps.msvc_request_medicine.application.mappers.RequestMedicineMapper;
import com.nuevaeps.msvc_request_medicine.domain.ports.in.RequestMedicineIn;
import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.FilterRequestMedicine;
import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.RequestMedicineRequest;
import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.ResponseRequestMedicine;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RequestMedicineService implements RequestMedicineUseCase {
    
    private final RequestMedicineIn requestMedicineIn;
    private final RequestMedicineMapper requestMedicineMapper; 

    @Override
    public ResponseRequestMedicine createRequest(HttpServletRequest requestHeader, RequestMedicineRequest request) {
        return requestMedicineIn.createRequest(requestHeader, requestMedicineMapper.dtorequestToDtoRequestModel(request));
    }

    @Override
    public Page<ResponseRequestMedicine> getPagRequests(FilterRequestMedicine filterRequestMedicine) {
        return requestMedicineIn.getPagRequests(filterRequestMedicine);
    }

}
