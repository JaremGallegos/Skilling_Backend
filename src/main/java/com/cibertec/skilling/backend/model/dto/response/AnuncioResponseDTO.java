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
public class AnuncioResponseDTO {
    private Integer id;
    private String titulo;
    private String descripcion;
    private LocalDateTime fecha;

    private ClaseResponseDTO claseId;
}
