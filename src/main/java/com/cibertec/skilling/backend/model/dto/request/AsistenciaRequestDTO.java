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
public class AsistenciaRequestDTO {
    @NotNull(message = "El campo fecha no puede ser nulo")
    private LocalDateTime fecha;

    @NotBlank(message = "El campo presente no puede ser nulo o vacio")
    private String presente;

    @NotBlank(message = "El campo estudiante_id no puede ser nulo o vacio")
    private String estudianteId;

    @NotNull(message = "El campo leccion_id no puede ser nulo")
    private Integer leccionId;
}
