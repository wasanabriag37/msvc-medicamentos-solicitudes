package com.nuevaeps.msvc_request_medicine.infrastruture.mappers;

import java.util.Set;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.nuevaeps.msvc_request_medicine.domain.models.RequestMedicineModel;
import com.nuevaeps.msvc_request_medicine.domain.models.User;
import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.ResponseRequestMedicine;
import com.nuevaeps.msvc_request_medicine.infrastruture.output.persistence.entities.MedicineEntity;
import com.nuevaeps.msvc_request_medicine.infrastruture.output.persistence.entities.RequestMedicineEntity;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
@DecoratedWith(MapperRequestMedicineInfDecorator.class)
public interface MapperRequestMedicineInf {

    @Mapping(source = "medicineEntity.dataAdditionsRequest", target = "dataAddRequestMedicine")
    @Mapping(source = "user", target = "user")
    ResponseRequestMedicine requestMedicineEntityToResponse(RequestMedicineEntity medicineEntity, User user);

    @Mapping(source = "user.userId", target = "userId")
    @Mapping(source = "medicineEntity", target = "medicine")
    RequestMedicineEntity requestMedicineModelToEntity(RequestMedicineModel requestMedicineModel,  User user, MedicineEntity medicineEntity);

    @Mapping(source = "requestMedicineEntities.dataAdditionsRequest", target = "dataAddRequestMedicine")
    Set<ResponseRequestMedicine> requestMedicineEntitiesToResponses(Set<RequestMedicineEntity> requestMedicineEntities);

     @Mapping(source = "medicineEntity.dataAdditionsRequest", target = "dataAddRequestMedicine")
    ResponseRequestMedicine requestMedicineEntityToResponseUn(RequestMedicineEntity medicineEntity);
    
}
