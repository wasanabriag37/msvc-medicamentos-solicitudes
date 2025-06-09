package com.nuevaeps.msvc_request_medicine.domain.ports.out;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nuevaeps.msvc_request_medicine.domain.models.RequestMedicineModel;
import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.FilterRequestMedicine;
import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.ResponseRequestMedicine;

import jakarta.servlet.http.HttpServletRequest;

public interface RequestMedicineOut {
    ResponseRequestMedicine createRequest(HttpServletRequest requestHeader, RequestMedicineModel request);
    Page<ResponseRequestMedicine> getPagRequests(FilterRequestMedicine filterRequestMedicine, Pageable pageable);
}
