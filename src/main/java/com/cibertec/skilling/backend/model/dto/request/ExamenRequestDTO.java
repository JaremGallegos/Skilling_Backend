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
public class ExamenRequestDTO {
    @NotBlank(message = "El campo titulo no puede estar vacio o nulo")
    private String titulo;
    
    @NotNull(message = "El campo horaInicio no puede ser nulo")
    private LocalDateTime horaInicio;
    
    @NotNull(message = "El campo horaFin no puede ser nulo")
    private LocalDateTime horaFin;
    
    @NotNull(message = "El campo leccion_id no puede ser nulo")
    private Integer leccionId;
}
