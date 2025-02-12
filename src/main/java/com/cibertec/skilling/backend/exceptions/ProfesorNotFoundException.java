package com.cibertec.skilling.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProfesorNotFoundException extends RuntimeException {
    public ProfesorNotFoundException(String message) {
        super(message);
    }
}
