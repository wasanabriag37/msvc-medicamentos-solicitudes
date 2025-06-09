package com.nuevaeps.msvc_request_medicine.infrastruture.output.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nuevaeps.msvc_request_medicine.infrastruture.output.persistence.entities.DataAdditionsRequestEntity;

public interface DataAdditionsRequestRepository extends JpaRepository<DataAdditionsRequestEntity, Integer>{

}
