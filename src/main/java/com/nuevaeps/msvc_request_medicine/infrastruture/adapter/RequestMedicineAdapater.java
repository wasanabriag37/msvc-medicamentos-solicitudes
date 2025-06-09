package com.nuevaeps.msvc_request_medicine.infrastruture.adapter;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nuevaeps.msvc_request_medicine.domain.models.RequestMedicineModel;
import com.nuevaeps.msvc_request_medicine.domain.models.User;
import com.nuevaeps.msvc_request_medicine.domain.ports.out.RequestMedicineOut;
import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.FilterRequestMedicine;
import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.ResponseRequestMedicine;
import com.nuevaeps.msvc_request_medicine.infrastruture.mappers.DataAdditionsRequestMapperInf;
import com.nuevaeps.msvc_request_medicine.infrastruture.mappers.MapperRequestMedicineInf;
import com.nuevaeps.msvc_request_medicine.infrastruture.output.persistence.entities.DataAdditionsRequestEntity;
import com.nuevaeps.msvc_request_medicine.infrastruture.output.persistence.entities.RequestMedicineEntity;
import com.nuevaeps.msvc_request_medicine.infrastruture.output.persistence.repositories.DataAdditionsRequestRepository;
import com.nuevaeps.msvc_request_medicine.infrastruture.output.persistence.repositories.MedicineRepository;
import com.nuevaeps.msvc_request_medicine.infrastruture.output.persistence.repositories.RequestMedicineRepository;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RequestMedicineAdapater  implements RequestMedicineOut{
    
    private final RequestMedicineRepository requestMedicineRepository;
    private final MapperRequestMedicineInf mapperRequestMedicineInf;
    private final MedicineRepository medicineRepository;
    private final DataAdditionsRequestMapperInf additionsRequestMapperInf;
    private final DataAdditionsRequestRepository dataAdditionsRequestRepository;

    @Override
    public ResponseRequestMedicine createRequest(HttpServletRequest requestHeader, RequestMedicineModel request) {
        User user = convertObject(requestHeader.getHeader("X-User-Info"));
        RequestMedicineEntity requestMedicineEntity = requestMedicineRepository.save(mapperRequestMedicineInf.requestMedicineModelToEntity(request, user, medicineRepository.findByMedicineId(request.getMedicineId())));
        if(!requestMedicineEntity.getMedicine().isCoveragePos()) {
            DataAdditionsRequestEntity dataAdditionsRequestEntity = additionsRequestMapperInf.dataAddRequestMedicineToEntity(request.getDataAddRequestMedicine());
            dataAdditionsRequestEntity.setRequestMedicine(requestMedicineEntity);
            requestMedicineEntity.setDataAdditionsRequest(dataAdditionsRequestRepository.save(dataAdditionsRequestEntity));
        }
        return mapperRequestMedicineInf.requestMedicineEntityToResponse(
                        requestMedicineEntity, user);
    }

    @Override
    public Page<ResponseRequestMedicine> getPagRequests(FilterRequestMedicine filterRequestMedicine, Pageable pageable) {
        Page<RequestMedicineEntity> requestMedicinePage = requestMedicineRepository.findRequestWithParameters(filterRequestMedicine, pageable);
        Set<ResponseRequestMedicine> responseRequestMedicines = mapperRequestMedicineInf.requestMedicineEntitiesToResponses(requestMedicinePage.getContent().stream().collect(Collectors.toSet()));
        return new PageImpl<>(responseRequestMedicines.stream().toList(), pageable, requestMedicinePage.getTotalElements());
    }

    private User convertObject(String requestHeader) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return objectMapper.readValue(requestHeader, User.class);
        } catch (Exception e) {
            return null;
        }
    }

}
