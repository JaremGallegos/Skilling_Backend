package com.cibertec.skilling.backend.model;

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
@Table(name = "Examen")
@Entity(name = "Examen")
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "horaInicio", nullable = false)
    private LocalDateTime horaInicio;

    @Column(name = "horaFin", nullable = false)
    private LocalDateTime horaFin;

    @ManyToOne
    @JoinColumn(name = "leccion_id", nullable = false)
    private Leccion leccion;

    @OneToMany(mappedBy = "examen")
    private List<Resultado> resultados;
}
