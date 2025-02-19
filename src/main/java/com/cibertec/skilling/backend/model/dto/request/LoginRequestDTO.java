package com.cibertec.skilling.backend.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO {
    @NotBlank(message = "El campo email no puede estar vacío")
    @Email(message = "El email debe tener un formato válido")
    private String email;
    
    @NotBlank(message = "El campo clave no puede estar vacío")
    private String clave;
}
