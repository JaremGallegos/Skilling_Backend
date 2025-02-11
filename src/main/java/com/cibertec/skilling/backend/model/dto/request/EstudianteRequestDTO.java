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
public class EstudianteRequestDTO {
    @NotBlank(message = "El campo usuario no puede ser vacio o nulo")
    private String usuario;
    
    @NotBlank(message = "El campo nombre no puede ser vacio o nulo")
    private String nombre;

    @NotBlank(message = "El campo apellido no puede ser vacio o nulo")
    private String apellido;

    @NotBlank(message = "El campo correo no puede ser vacio o nulo")
    private String correo;
    
    @NotBlank(message = "El campo telefono no puede ser vacio o nulo")
    private String telefono;

    @NotBlank(message = "El campo telefono no puede ser vacio o nulo")
    private String direccion;

    @NotNull(message = "El campo imagen no puede ser nulo")
    private byte[] imagen;

    @NotBlank(message = "El campo sexo no puede ser vacio o nulo")
    private String sexo;

    @NotNull(message = "El campo fechaNacimiento no puede ser nulo")
    private LocalDateTime fechaNacimiento;

    @NotNull(message = "El campo grado_id no puede ser nulo")
    private Integer gradoId;

    @NotNull(message = "El campo clase_id no puede ser nulo")
    private Integer claseId;

    @NotBlank(message = "El campo usuario_id no puede ser nulo")
    private String usuarioId;
}
