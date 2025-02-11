package com.cibertec.skilling.backend.model.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LeccionRequest {
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    
    @NotBlank(message = "El día es obbligatorio")
    private String dia;
    
    @NotNull(message = "La hora de inicio es obligatorio")
    private LocalDateTime horaInicio;
    
    @NotNull(message = "La hora de fin es obligatorio")
    private LocalDateTime horaFin;

    @NotNull(message = "El id de la materia es obligatorio")
    private Integer materiaId;

    @NotNull(message = "El id de la clase es obligatorio")
    private Integer claseId;

    @NotBlank(message = "El id del profesor es obligatorio")
    private String profesorId;
}
