package com.nuevaeps.msvc_request_medicine.infrastruture.input.controllers;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nuevaeps.msvc_request_medicine.application.intput.RequestMedicineUseCase;
import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.FilterRequestMedicine;
import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.RequestMedicineRequest;
import com.nuevaeps.msvc_request_medicine.infrastruture.input.models.ResponseRequestMedicine;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/requestMedicine")
@RequiredArgsConstructor
public class ControllerRequestMedicine {

    private final RequestMedicineUseCase requestMedicineUseCase;

    @Operation(
            summary = "crear solcitud medicamentos",
            description = "crear solcitud medicamentos"
    )
    @PostMapping(
            value = "/createRequest"
    )
    public ResponseRequestMedicine createRequest(HttpServletRequest requestHeader, @RequestBody @Valid RequestMedicineRequest request) {
        return requestMedicineUseCase.createRequest(requestHeader, request);
    }

     @Operation(
            summary = "obtener de solicitudes para aiflow",
            description = "Endpoint reactivo obtener de solicitudes para aiflow - permiso: Permiso Estandar ",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Stream de validaciones exitoso",
                            content = @Content(schema = @Schema(implementation = ResponseRequestMedicine.class))
                    )
            }
    )
    @GetMapping(
            value = "/getRequestMedicinePag"
    )
    public Page<ResponseRequestMedicine> getRequestMedicinePag(@ModelAttribute  FilterRequestMedicine filterRequestMedicine) {
        return requestMedicineUseCase.getPagRequests(filterRequestMedicine);
    }

}
