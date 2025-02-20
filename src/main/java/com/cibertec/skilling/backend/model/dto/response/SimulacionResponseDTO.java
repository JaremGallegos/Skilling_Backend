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
public class SimulacionResponseDTO {
    private String id;
    private String nombre;
    private String descripcion;
    private String estado;
    private LocalDateTime tiempoInicio;
    private LocalDateTime tiempoFin;
}