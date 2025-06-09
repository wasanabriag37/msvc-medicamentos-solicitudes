package com.nuevaeps.msvc_request_medicine.domain.exceptions;

public class ExceptionDataAddRequestFound extends RuntimeException {
    public ExceptionDataAddRequestFound() {
        super("Faltan datos para completar la solicitud");
    }
}
