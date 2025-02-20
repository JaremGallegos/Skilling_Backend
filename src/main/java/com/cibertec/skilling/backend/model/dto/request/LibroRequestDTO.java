package com.cibertec.skilling.backend.model.dto.request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LibroRequestDTO {
    private String titulo;
    private String autor;
    private String isbn;
    private LocalDateTime fechaPublicacion;
    private String resumen;
}