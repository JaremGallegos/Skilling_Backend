package com.cibertec.skilling.backend.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponseDTO {
    private String id;
    private String email;
    private String clave;

    private RolResponseDTO rol;
}
