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
@Table(name = "anuncio")
@Entity(name = "anuncio")
public class Anuncio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titulo", nullable = false)
    private String titulo;
    
    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;
    
    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "Clase_id", nullable = false, referencedColumnName = "id")
    private Clase clase;
}
