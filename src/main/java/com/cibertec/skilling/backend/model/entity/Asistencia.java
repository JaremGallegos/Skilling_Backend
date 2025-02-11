package com.cibertec.skilling.backend.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "asistencia")
@Entity(name = "asistencia")
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;
    
    @Column(name = "presente", length = 1, nullable = false)
    private String presente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Estudiante_id", referencedColumnName = "id", nullable = false)
    private Estudiante estudiante;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Leccion_id", referencedColumnName = "id", nullable = false)
    private Leccion leccion;
}
