package com.cibertec.skilling.backend.model.dto.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoResponseDTO {
    private Integer id;
    private BigDecimal puntaje;

    // Colecciones asociadas: Conjuntos de DTO
    private ExamenResponseDTO examenId;
    private TareaResponseDTO tareaId;
    private EstudianteResponseDTO estudianteId;
}
