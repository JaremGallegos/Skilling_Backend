package com.cibertec.skilling.backend.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.cibertec.skilling.backend.model.Sexo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Profesor")
public class Profesor {
    @Id
    private String id;
    
    @Column(name = "usuario", unique = true, nullable = false)
    private String usuario;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "correo", unique = true, nullable = false)
    private String correo;

    @Column(name = "telefono", unique = true, nullable = false)
    private String telefono;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "imagen", nullable = false)
    private String imagen;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexo", nullable = false)
    private Sexo sexo;

    @Builder.Default
    @Column(name = "fechaCreacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Column(name = "fechaNacimiento", nullable = false)
    private LocalDateTime fechaNacimiento;

    @OneToMany(mappedBy = "profesor")
    private List<Leccion> lecciones;

    @OneToMany(mappedBy = "profesor")
    private List<Clase> clases;
}
