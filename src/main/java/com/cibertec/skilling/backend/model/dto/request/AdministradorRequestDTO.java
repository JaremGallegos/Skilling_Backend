package com.cibertec.skilling.backend.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdministradorRequestDTO {
    @NotBlank(message = "EL campo usuario no puede ser vacio o nulo")
    private String usuario;
    
    @NotBlank(message = "El campo usuario_id no puede ser vacio o nulo")
    private String usuarioId;
}
