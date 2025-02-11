package com.cibertec.skilling.backend.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdministradorResponseDTO {
    private String id;
    private String usuario;

    private UsuarioResponseDTO usuarioId;
}
