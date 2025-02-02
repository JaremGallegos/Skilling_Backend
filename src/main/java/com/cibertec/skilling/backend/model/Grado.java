package com.cibertec.skilling.backend.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "Grado")
@Entity(name = "Grado")
public class Grado {   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column(name = "nivel", unique = true, nullable = false)
    private Integer nivel;

    @OneToMany(mappedBy = "grado")
    private List<Estudiante> estudiantes;

    @OneToMany(mappedBy = "grado")
    private List<Clase> clases;
}
