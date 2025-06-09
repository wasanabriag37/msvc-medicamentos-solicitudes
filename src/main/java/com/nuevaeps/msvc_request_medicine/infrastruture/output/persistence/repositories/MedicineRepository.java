package com.nuevaeps.msvc_request_medicine.infrastruture.output.persistence.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nuevaeps.msvc_request_medicine.infrastruture.output.persistence.entities.MedicineEntity;

public interface MedicineRepository extends JpaRepository<MedicineEntity, Integer> {
    boolean existsByNameMedicine(String name);

   @Query("SELECT m FROM MedicineEntity m " +
    "WHERE (:name IS NULL OR UPPER(m.nameMedicine) LIKE UPPER(CONCAT('%', :name, '%'))) " +
    "AND (:code IS NULL OR m.code = :code) " +
    "AND (:coverage IS NULL OR m.coveragePos = :coverage)")
Page<MedicineEntity> findMedicineByName(
        @Param("name") String name,
        @Param("code") Long code,
        @Param("coverage") Boolean coverage,
        Pageable pageable);

    MedicineEntity findByMedicineId(int id);

    @Query("SELECT m.coveragePos FROM MedicineEntity m WHERE m.medicineId = ?1")
    Boolean findCoveragePosByMedicineId(int medicineId);
}
