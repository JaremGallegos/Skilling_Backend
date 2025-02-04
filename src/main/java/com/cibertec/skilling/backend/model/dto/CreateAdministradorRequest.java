package com.cibertec.skilling.backend.model.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateAdministradorRequest {
    @NotEmpty(message = "El campo de usuario no peude ser vacio o nulo")
    private String usuario;
}
