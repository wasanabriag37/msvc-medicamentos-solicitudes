package com.nuevaeps.msvc_request_medicine.application.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.nuevaeps.msvc_request_medicine.domain.models.Medicine;
import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.RequestMedicine;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MedicineMapper {
    Medicine requestMedicineToMedicine(RequestMedicine requestMedicine);
}
