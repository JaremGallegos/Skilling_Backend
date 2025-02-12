package com.cibertec.skilling.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AsistenciaNotFoundException extends RuntimeException {
    public AsistenciaNotFoundException(String message) {
        super(message);
    }
}
