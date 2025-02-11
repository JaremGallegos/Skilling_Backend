package com.cibertec.skilling.backend.model.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GradoResponseDTO {
    private Integer id;
    private String nivel;

    // Relaciones a colecciones: Anidar DTOs
    private List<EstudianteResponseDTO> estudiantes;
    private List<ClaseResponseDTO> clases;
}
