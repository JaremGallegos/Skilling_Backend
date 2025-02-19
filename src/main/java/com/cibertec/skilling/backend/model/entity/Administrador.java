package com.cibertec.skilling.backend.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "administrador")
@Entity(name = "administrador")
public class Administrador {
    @Id
    private String id;

    @Column(length = 100, nullable = false)
    private String usuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Usuario_id", referencedColumnName = "id", nullable = false)
    private Usuario usuarioRef;
}
