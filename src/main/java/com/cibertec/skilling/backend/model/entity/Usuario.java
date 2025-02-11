package com.cibertec.skilling.backend.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "usuario")
@Entity(name = "usuario")
public class Usuario {
    @Id
    private String id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String clave;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Rol_id", referencedColumnName = "id", nullable = false)
    private Rol rol;
}
