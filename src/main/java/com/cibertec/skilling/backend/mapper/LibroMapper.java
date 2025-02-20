package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.cibertec.skilling.backend.model.dto.request.LibroRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.LibroResponseDTO;
import com.cibertec.skilling.backend.model.entity.Libro;

@Mapper(componentModel = "spring")
public interface LibroMapper {
    LibroMapper INSTANCE = Mappers.getMapper(LibroMapper.class);
    
    Libro toEntity(LibroRequestDTO dto);
    
    LibroResponseDTO toResponseDTO(Libro entity);
}