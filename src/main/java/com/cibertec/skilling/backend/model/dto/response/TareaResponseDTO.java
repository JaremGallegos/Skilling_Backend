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
public class TareaResponseDTO {
    private Integer id;
    private String titulo;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaEntrega;

    private LeccionResponseDTO leccionId;

    // Colecciones asociadas: Conjuntos de DTO
    private List<ResultadoResponseDTO> resultados;
}
