package com.cibertec.skilling.backend.model.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteResponseDTO {
    private String id;
    private String usuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String direccion;
    private byte[] imagen;
    private String sexo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaNacimiento;

    private GradoResponseDTO gradoId;
    private ClaseResponseDTO claseId;
    private UsuarioResponseDTO usuarioId;
}
