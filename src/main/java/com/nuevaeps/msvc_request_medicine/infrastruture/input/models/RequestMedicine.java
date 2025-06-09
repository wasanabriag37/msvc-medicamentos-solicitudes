package com.nuevaeps.msvc_request_medicine.infrastruture.input.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RequestMedicine {
    @NotNull(message = "El código no puede ser nulo")
    @Positive(message = "El código debe ser un número positivo")
    private Long code;
    @NotBlank(message = "El nombre del medicamento no puede estar vacío")
    private String nameMedicine;
    private boolean coveragePos;
}
