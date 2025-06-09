package com.nuevaeps.msvc_request_medicine.domain.exceptions;

public class ExceptionMedicineDuplicate extends RuntimeException {
    public ExceptionMedicineDuplicate() {
        super("El nombre del medicamento ya existe en la base de datos");
    }
}