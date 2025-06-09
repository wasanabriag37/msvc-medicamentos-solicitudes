package com.nuevaeps.msvc_request_medicine.application.intput;

import org.springframework.data.domain.Page;

import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.FilterRequestMedicine;
import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.RequestMedicineRequest;
import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.ResponseRequestMedicine;

import jakarta.servlet.http.HttpServletRequest;

public interface RequestMedicineUseCase {
    ResponseRequestMedicine createRequest(HttpServletRequest requestHeader, RequestMedicineRequest request);
    Page<ResponseRequestMedicine> getPagRequests(FilterRequestMedicine filterRequestMedicine);
}
