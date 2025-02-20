package com.cibertec.skilling.backend.model.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "simulacion")
@Table(name = "simulacion")
public class Simulacion {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    @Column(name = "tiempo_inicio", nullable = false)
    private LocalDateTime tiempoInicio;

    @Column(name = "tiempo_fin", nullable = false)
    private LocalDateTime tiempoFin;
}