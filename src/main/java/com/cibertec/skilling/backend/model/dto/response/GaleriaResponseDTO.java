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
public class GaleriaResponseDTO {
    private String id;
    private String nombre;
    private String descripcion;
    private byte[] imagen;
    private LocalDateTime fechaCreacion;
    private String estado;
}