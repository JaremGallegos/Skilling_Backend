package com.cibertec.skilling.backend.model.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MateriaResponseDTO {
    private Integer id;
    private String nombre;

    // Colecciones asociadas: Conjuntos de DTO
    private List<LeccionResponseDTO> lecciones;
}
