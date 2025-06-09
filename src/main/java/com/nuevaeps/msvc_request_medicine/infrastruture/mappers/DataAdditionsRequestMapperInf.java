package com.nuevaeps.msvc_request_medicine.infrastruture.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.ResponseDataAddRequestMedicine;
import com.nuevaeps.msvc_request_medicine.infrastruture.output.persistence.entities.DataAdditionsRequestEntity;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DataAdditionsRequestMapperInf {
    DataAdditionsRequestEntity dataAddRequestMedicineToEntity(ResponseDataAddRequestMedicine dataAddRequestMedicine);
    ResponseDataAddRequestMedicine dataAdditionsRequestEntityToResponse(DataAdditionsRequestEntity additionsRequestEntity);
}
