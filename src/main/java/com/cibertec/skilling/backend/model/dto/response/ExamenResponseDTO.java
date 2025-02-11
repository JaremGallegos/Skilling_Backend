package com.cibertec.skilling.backend.model.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExamenResponseDTO {
    private Integer id;
    private String titulo;
    private LocalDateTime horaInicio;
    private LocalDateTime horaFin;

    private LeccionResponseDTO leccion;

    // Relaciones a colecciones: Anidar DTOs
    private List<ResultadoResponseDTO> resultados;
}
