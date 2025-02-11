package com.cibertec.skilling.backend.model.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GradoRequestDTO {
    @NotNull(message = "El campo nivel no puede ser nulo")
    private String nivel;
}
