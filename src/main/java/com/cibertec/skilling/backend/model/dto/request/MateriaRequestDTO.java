package com.cibertec.skilling.backend.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MateriaRequestDTO {
    @NotBlank(message = "El campo nombre no puede estar vacio o nulo")
    private String nombre;
}
