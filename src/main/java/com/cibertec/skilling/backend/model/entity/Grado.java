package com.cibertec.skilling.backend.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "grado")
@Entity(name = "grado")
public class Grado {   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column(name = "nivel", unique = true, nullable = false)
    private String nivel;

    @OneToMany(mappedBy = "grado")
    private List<Estudiante> estudiantes;

    @OneToMany(mappedBy = "grado")
    private List<Clase> clases;
}
