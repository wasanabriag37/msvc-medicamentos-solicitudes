package com.nuevaeps.msvc_request_medicine.infrastruture.output.persistence.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.FilterRequestMedicine;
import com.nuevaeps.msvc_request_medicine.infrastruture.output.persistence.entities.RequestMedicineEntity;

public interface RequestMedicineRepository extends JpaRepository<RequestMedicineEntity, Integer>{
 

@Query(
    "SELECT r FROM RequestMedicineEntity r " +
    " JOIN FETCH r.medicine m " +
    " LEFT JOIN FETCH r.dataAdditionsRequest d " +
    " WHERE (:#{#filter.nameMedicine} IS NULL OR :#{#filter.nameMedicine} = '' OR LOWER(m.nameMedicine) LIKE LOWER(CONCAT('%', TRIM(:#{#filter.nameMedicine}), '%'))) " +
    " AND (:#{#filter.code} IS NULL OR m.code = :#{#filter.code}) " +
    " AND (:#{#filter.requestMedicineId} IS NULL OR r.requestMedicineId = :#{#filter.requestMedicineId}) " +
    " AND (:#{#filter.numberOrder} IS NULL OR (d IS NOT NULL AND d.numberOrder = :#{#filter.numberOrder})) " +
    " AND (:#{#filter.coveragePos} IS NULL OR m.coveragePos = :#{#filter.coveragePos}) " +
    " AND (:#{#filter.usersIds} IS NULL OR r.userId IN :#{#filter.usersIds}) " +
    " AND (:#{#filter.medicineIds} IS NULL OR m.medicineId IN :#{#filter.medicineIds}) " 
    )
Page<RequestMedicineEntity> findRequestWithParameters(
    @Param("filter") FilterRequestMedicine filter,
    Pageable pageable);

    
}
