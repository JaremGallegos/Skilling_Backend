package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.cibertec.skilling.backend.model.dto.request.SimulacionRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.SimulacionResponseDTO;
import com.cibertec.skilling.backend.model.entity.Simulacion;

@Mapper(componentModel = "spring")
public interface SimulacionMapper {
    SimulacionMapper INSTANCE = Mappers.getMapper(SimulacionMapper.class);
    
    Simulacion toEntity(SimulacionRequestDTO dto);
    
    SimulacionResponseDTO toResponseDTO(Simulacion entity);
}