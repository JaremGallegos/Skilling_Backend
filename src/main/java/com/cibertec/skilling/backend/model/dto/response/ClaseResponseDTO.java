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
public class ClaseResponseDTO {
    private Integer id;
    private String nombre;
    private Integer capacidad;

    private GradoResponseDTO gradoId;
    private ProfesorResponseDTO profesorId;

    // Relaciones a colecciones: Anidar DTOs
    private List<LeccionResponseDTO> lecciones;
    private List<EstudianteResponseDTO> estudiantes;
    private List<EventoResponseDTO> eventos;
    private List<AnuncioResponseDTO> anuncios;
}
