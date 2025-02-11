package com.cibertec.skilling.backend.model.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoRequestDTO {
    @NotNull(message = "El campo puntaje no puede ser nulo")
    private BigDecimal puntaje;
    
    @NotNull(message = "El campo examen_id no puede ser nulo")
    private Integer examenId;

    @NotNull(message = "El campo tarea_id no puede ser nulo")
    private Integer tareaId;

    @NotNull(message = "El campo estudiante_id no puede ser nulo")
    private String estudianteId;
}
