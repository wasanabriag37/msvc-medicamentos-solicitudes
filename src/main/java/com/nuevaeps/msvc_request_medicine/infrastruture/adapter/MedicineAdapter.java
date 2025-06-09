package com.nuevaeps.msvc_request_medicine.infrastruture.adapter;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nuevaeps.msvc_request_medicine.domain.models.Medicine;
import com.nuevaeps.msvc_request_medicine.domain.ports.out.MedicineOut;
import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.ResponseMedicine;
import com.nuevaeps.msvc_request_medicine.infrastruture.mappers.MapperMedicineInf;
import com.nuevaeps.msvc_request_medicine.infrastruture.output.persistence.entities.MedicineEntity;
import com.nuevaeps.msvc_request_medicine.infrastruture.output.persistence.repositories.MedicineRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicineAdapter implements MedicineOut {
    
    
    private final MedicineRepository medicineRepository;
    private final MapperMedicineInf mapperMedicineInf;
    
    @Override
    public boolean existsMedicineByname(String name) {
        return medicineRepository.existsByNameMedicine(name);
    }

    @Override
    public ResponseMedicine create(Medicine medicine) {
        return mapperMedicineInf.medicineEntityToResponseMedicine(medicineRepository.save(mapperMedicineInf.medicineToMedicineEntity(medicine)));
    }

    @Override
    public List<ResponseMedicine> getAll() {
        return mapperMedicineInf.medicineEntitiesToResponseMedicines(medicineRepository.findAll());
    }

    @Override
    public Page<ResponseMedicine> getPag(String name, Long code, Boolean coverage, Pageable pageable) {
        Page<MedicineEntity> pag =  medicineRepository.findMedicineByName(name, code, coverage, pageable);
        List<ResponseMedicine> list = mapperMedicineInf.medicineEntitiesToResponseMedicines(pag.getContent());
        return new PageImpl<>(list, pageable, pag.getTotalElements());
    }

    @Override
    public boolean isCoveragePos(int id) {
        return medicineRepository.findCoveragePosByMedicineId(id);
    }

}
