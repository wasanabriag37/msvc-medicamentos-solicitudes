package com.nuevaeps.msvc_request_medicine.infrastruture.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.nuevaeps.msvc_request_medicine.domain.models.Medicine;
import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.ResponseMedicine;
import com.nuevaeps.msvc_request_medicine.infrastruture.output.persistence.entities.MedicineEntity;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapperMedicineInf {
    ResponseMedicine medicineEntityToResponseMedicine(MedicineEntity medicineEntity);
    MedicineEntity medicineToMedicineEntity(Medicine medicine);
    List<ResponseMedicine> medicineEntitiesToResponseMedicines(List<MedicineEntity> entities);
}
