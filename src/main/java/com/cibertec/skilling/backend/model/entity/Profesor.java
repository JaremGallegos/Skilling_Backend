package com.cibertec.skilling.backend.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.cibertec.skilling.backend.model.Sexo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity(name = "profesor")
@Table(name = "profesor")
public class Profesor {
    @Id
    private String id;
    
    @Column(name = "usuario", nullable = false, length = 100)
    private String usuario;

    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 150)
    private String apellido;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "telefono", length = 15, nullable = false)
    private String telefono;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Lob
    @Column(name = "imagen", nullable = false)
    private byte[] imagen;

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

    @ManyToOne(optional = false)
    @JoinColumn(name = "Usuario_id", referencedColumnName = "id")
    private Usuario usuarioRef;
}
