package com.cibertec.skilling.backend.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {
    @NotBlank(message = "El campo email no puede estar vacio o nulo")
    @Email(message = "El campo email debe tener un formato valido")
    private String email;

    @NotBlank(message = "El campo clave no puede estar vacio o nulo")
    private String clave;

    @NotNull(message = "El campo rol_id no puede ser nulo")
    private Integer rolId;
}
