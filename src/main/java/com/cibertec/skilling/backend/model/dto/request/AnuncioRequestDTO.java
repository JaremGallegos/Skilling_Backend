package com.cibertec.skilling.backend.model.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnuncioRequestDTO {
    @NotBlank(message = "El campo titulo no puede ser vacio o nulo")
    private String titulo;

    @NotBlank(message = "El campo descripcion no puede ser vacio o nulo")
    private String descripcion;

    @NotNull(message = "El campo fecha no puede ser nulo")
    private LocalDateTime fecha;

    @NotNull(message = "El campo clase_id no puede ser nulo")
    private Integer claseId;
}
