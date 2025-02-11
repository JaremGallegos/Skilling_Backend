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
public class TareaRequestDTO {
    @NotBlank(message = "El campo titulo no puede estar vacio o nulo")
    private String titulo;

    @NotNull(message = "El campo fechaInicio no puede ser nulo")
    private LocalDateTime fechaInicio;

    @NotNull(message = "El campo fechaEntrega no puede ser nulo")
    private LocalDateTime fechaEntrega;

    @NotNull(message = "El campo leccion_id no puede ser nulo")
    private Integer leccionId;
}
