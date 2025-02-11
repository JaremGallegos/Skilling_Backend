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
public class RolRequestDTO {
    @NotBlank(message = "El campo tipo no puede estar vacio o nulo")
    private String tipo;
}
