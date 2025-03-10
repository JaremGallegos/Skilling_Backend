package com.cibertec.skilling.backend.model.dto.request;

import java.time.LocalDate;

import com.cibertec.skilling.backend.utils.ByteArrayDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

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
public class ProfesorRequestDTO {
    @NotBlank(message = "El campo usuario no puede ser vacío o nulo")
    private String usuario;

    @NotBlank(message = "El campo nombre no puede ser vacío o nulo")
    private String nombre;

    @NotBlank(message = "El campo apellido no puede ser vacío o nulo")
    private String apellido;

    @NotBlank(message = "El campo correo no puede ser vacío o nulo")
    private String correo;

    @NotBlank(message = "El campo telefono no puede ser vacío o nulo")
    private String telefono;

    @NotBlank(message = "El campo direccion no puede ser vacío o nulo")
    private String direccion;

    @NotNull(message = "El campo imagen no puede ser nulo")
    @JsonDeserialize(using = ByteArrayDeserializer.class)
    private byte[] imagen;

    @NotBlank(message = "El campo sexo no puede ser vacío o nulo")
    private String sexo;

    @NotNull(message = "El campo fechaNacimiento no puede ser nulo")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    @NotBlank(message = "El campo usuario_id no puede ser vacío o nulo")
    private String usuarioId;
}
