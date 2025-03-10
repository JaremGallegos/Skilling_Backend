package com.cibertec.skilling.backend.model.dto.request;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimulacionRequestDTO {
    private String nombre;
    private String descripcion;
    private String estado;
    private LocalDateTime tiempoInicio;
    private LocalDateTime tiempoFin;
}