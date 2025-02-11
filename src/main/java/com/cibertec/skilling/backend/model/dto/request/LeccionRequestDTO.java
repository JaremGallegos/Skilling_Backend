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
public class LeccionRequestDTO {
    @NotBlank(message = "El campo nombre no puede estar vacio o nulo")
    private String nombre;
    
    @NotBlank(message = "El campo dia no puede estar vacio o nulo")
    private String dia;
    
    @NotNull(message = "El campo horaInicio no puede ser nulo")
    private LocalDateTime horaInicio;
    
    @NotNull(message = "El campo horaFin no puede ser nulo")
    private LocalDateTime horaFin;

    @NotNull(message = "El campo materia_id no puede ser nulo")
    private Integer materiaId;

    @NotNull(message = "El campo clase_id no puede ser nulo")
    private Integer claseId;

    @NotBlank(message = "El campo profesor_id no puede estar vacio o nulo")
    private String profesorId;
}
