package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.cibertec.skilling.backend.model.dto.request.GaleriaRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.GaleriaResponseDTO;
import com.cibertec.skilling.backend.model.entity.Galeria;

@Mapper(componentModel = "spring")
public interface GaleriaMapper {
    GaleriaMapper INSTANCE = Mappers.getMapper(GaleriaMapper.class);
    
    Galeria toEntity(GaleriaRequestDTO dto);
    
    GaleriaResponseDTO toResponseDTO(Galeria entity);
}