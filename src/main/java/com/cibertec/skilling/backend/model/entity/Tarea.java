package com.cibertec.skilling.backend.model.entity;

import java.time.LocalDateTime;
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
@Table(name = "tarea")
@Entity(name = "tarea")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "fechaInicio", nullable = false)
    private LocalDateTime fechaInicio;

    @Column(name = "fechaEntrega", nullable = false)
    private LocalDateTime fechaEntrega;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Leccion_id", referencedColumnName = "id", nullable = false)
    private Leccion leccion;

    @OneToMany(mappedBy = "tarea")
    private List<Resultado> resultados;
}
