package com.nuevaeps.msvc_request_medicine.application.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.nuevaeps.msvc_request_medicine.domain.models.RequestMedicineModel;
import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.RequestMedicineRequest;


@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RequestMedicineMapper {
    @Mapping(source = "requestMedicineRequest.dataAdditionsRequestRequest", target = "dataAddRequestMedicine")
    RequestMedicineModel dtorequestToDtoRequestModel(RequestMedicineRequest requestMedicineRequest);
}
