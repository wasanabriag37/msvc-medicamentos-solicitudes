package com.nuevaeps.msvc_request_medicine.infrastruture.input.models;

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
public class RequestMedicineRequest {
     @NotNull(message = "El medicamento no puede ser nulo")
     private int medicineId;
     @NotNull(message = "El código no puede ser nulo")
     @Positive(message = "El código debe ser un número positivo")
     private Integer amount;
     private DataAdditionsRequestRequest dataAdditionsRequestRequest;
}
