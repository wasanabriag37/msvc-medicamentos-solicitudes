package com.nuevaeps.msvc_request_medicine.infrastruture.input.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nuevaeps.msvc_request_medicine.application.intput.MedicineUseCase;
import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.RequestMedicine;
import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.ResponseMedicine;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/medicine")
@RequiredArgsConstructor
public class ControllerMedicine {

    private final MedicineUseCase medicineUseCase;

    
    @Operation(
            summary = "crear Medicamento",
            description = "crear Medicamento"
    )
    @PostMapping(
            value = "/create"
    )
    public ResponseMedicine create(@RequestBody @Valid RequestMedicine request) {
        return medicineUseCase.create(request);
    }

    @Operation(
            summary = "obtener medicamnetos con paginacion",
            description = "obtener medicamnetos con paginacion"
    )
    @GetMapping(
            value = "/getPag"
    )
    public Page<ResponseMedicine> getPag(@RequestParam(value = "nombreMedicamento",required = false) String name, @RequestParam(value = "cantidadRegistros",required = false) Integer cantRecords, @RequestParam(value = "codigo",required = false) Long code, @RequestParam(value = "coberturaPos",required = false) Boolean coverage,
                                                                @RequestParam(value = "PaginaActual", required = false) Integer pagCurrent) {
        return medicineUseCase.getPag(name, code, coverage, cantRecords, pagCurrent);
    }

    @Operation(
            summary = "Obtener todos los medicamentos",
            description = "Obtener todos los medicamentos"
    )
    @GetMapping(
            value = "/getAll"
    )
    public List<ResponseMedicine> getAll() {
        return medicineUseCase.getlAll();
    }

}
