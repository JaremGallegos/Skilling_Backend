package com.cibertec.skilling.backend.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.cibertec.skilling.backend.model.Dia;
import com.cibertec.skilling.backend.model.DiaConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "leccion")
@Entity(name = "leccion")
public class Leccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Convert(converter = DiaConverter.class)
    @Column(name = "dia", nullable = false)
    private Dia dia;

    @Column(name = "horaInicio", nullable = false)
    private LocalDateTime horaInicio;

    @Column(name = "horaFin", nullable = false)
    private LocalDateTime horaFin;

    @ManyToOne
    @JoinColumn(name = "Materia_id", referencedColumnName = "id", nullable = false)
    private Materia materia;

    @ManyToOne
    @JoinColumn(name = "Clase_id", referencedColumnName = "id", nullable = false)
    private Clase clase;

    @ManyToOne
    @JoinColumn(name = "Profesor_id", referencedColumnName = "id", nullable = false)
    private Profesor profesor;

    @OneToMany(mappedBy = "leccion")
    private List<Examen> examenes;

    @OneToMany(mappedBy = "leccion")
    private List<Tarea> tareas; 

    @OneToMany(mappedBy = "leccion")
    private List<Asistencia> asistencias;
}
