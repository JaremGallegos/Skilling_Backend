package com.cibertec.skilling.backend.model.dto.request;

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
public class ClaseRequestDTO {
    @NotBlank(message = "El campo nombre no puede ser vacio o nulo")
    private String nombre;

    @NotNull(message = "El campo capacidad no puede ser nulo")
    private Integer capacidad;

    @NotNull(message = "El campo grado_id no puede ser nulo")
    private Integer gradoId;

    @NotBlank(message = "El camppo profesor_id no puede ser nulo")
    private String profesorId;
}
