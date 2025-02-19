package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.cibertec.skilling.backend.model.dto.request.EventoRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.ClaseResponseDTO;
import com.cibertec.skilling.backend.model.dto.response.EventoResponseDTO;
import com.cibertec.skilling.backend.model.entity.Evento;

@Mapper(componentModel = "spring")
public interface EventoMapper {

    @Mapping(target = "clase.id", source = "claseId")
    Evento toEntity(EventoRequestDTO requestDTO);

    @Mapping(source = "clase.id", target = "claseId", qualifiedByName = "mapClase")
    EventoResponseDTO toResponseDTO(Evento evento);

    @Named("mapClase")
    default ClaseResponseDTO mapClase(Integer id) {
        if (id == null) {
            return null;
        }
        return ClaseResponseDTO.builder().id(id).build();
    }
}
