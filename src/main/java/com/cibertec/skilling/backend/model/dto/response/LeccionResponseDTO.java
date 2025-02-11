package com.cibertec.skilling.backend.model.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeccionResponseDTO {
    private Integer id;
    private String nombre;
    private String dia;
    private LocalDateTime horaInicio;
    private LocalDateTime horaFin;

    private MateriaResponseDTO materiaId;
    private ClaseResponseDTO claseId;
    private ProfesorResponseDTO profesorId;

    // Colecciones asociadas: Conjuntos de DTO
    private List<ExamenResponseDTO> examenes;
    private List<TareaResponseDTO> tareas;
    private List<AsistenciaResponseDTO> asistencias;
}
