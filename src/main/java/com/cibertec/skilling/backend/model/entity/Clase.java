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
@Table(name = "Clase")
@Entity(name = "Clase")
public class Clase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", unique = true, nullable = false)
    private String nombre;

    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;

    @ManyToOne
    @JoinColumn(name = "grado_id", nullable = false)
    private Grado grado;

    @ManyToOne
    @JoinColumn(name = "profesor_id",  nullable = false)
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
