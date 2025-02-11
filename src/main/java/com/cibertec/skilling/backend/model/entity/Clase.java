package com.cibertec.skilling.backend.model.entity;

import java.util.List;

import jakarta.persistence.Column;
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
@Table(name = "clase")
@Entity(name = "clase")
public class Clase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", unique = true, nullable = false)
    private String nombre;

    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Grado_id", referencedColumnName = "id", nullable = false)
    private Grado grado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Profesor_id", referencedColumnName = "id", nullable = false)
    private Profesor profesor;

    @OneToMany(mappedBy = "clase")
    private List<Leccion> lecciones;

    @OneToMany(mappedBy = "clase")
    private List<Estudiante> estudiantes;

    @OneToMany(mappedBy = "clase")
    private List<Evento> eventos;

    @OneToMany(mappedBy = "clase")
    private List<Anuncio> anuncios;
}
