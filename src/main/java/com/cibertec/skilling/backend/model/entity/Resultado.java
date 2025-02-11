package com.cibertec.skilling.backend.model.entity;

import java.math.BigDecimal;

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
@Table(name = "resultado")
@Entity(name = "resultado")
public class Resultado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "puntaje", nullable = false, precision = 5, scale = 2)
    private BigDecimal puntaje;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Examen_id", nullable = false)
    private Examen examen;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Tarea_id", nullable = false)
    private Tarea tarea;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Estudiante_id", nullable = false)
    private Estudiante estudiante;
}
