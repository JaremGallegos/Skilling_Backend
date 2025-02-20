package com.cibertec.skilling.backend.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GaleriaRequestDTO {
    private String nombre;
    private String descripcion;
    private byte[] imagen;
    private String estado;
}