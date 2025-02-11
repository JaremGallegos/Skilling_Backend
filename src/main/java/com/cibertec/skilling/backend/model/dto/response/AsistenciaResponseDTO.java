package com.cibertec.skilling.backend.model.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AsistenciaResponseDTO {
    private Integer id;
    private LocalDateTime fecha;
    private String presente;

    private EstudianteResponseDTO estudianteId;
    private LeccionResponseDTO leccionId;
}
