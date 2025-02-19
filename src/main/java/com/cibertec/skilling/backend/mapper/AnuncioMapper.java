package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.cibertec.skilling.backend.model.dto.request.AnuncioRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.AnuncioResponseDTO;
import com.cibertec.skilling.backend.model.dto.response.ClaseResponseDTO;
import com.cibertec.skilling.backend.model.entity.Anuncio;

@Mapper(componentModel = "spring")
public interface AnuncioMapper {

    @Mapping(target = "clase.id", source = "claseId")
    Anuncio toEntity(AnuncioRequestDTO requestDTO);

    @Mapping(source= "clase.id", target = "claseId", qualifiedByName = "mapClase")
    AnuncioResponseDTO toResponseDTO(Anuncio anuncio);

    @Named("mapClase")
    default ClaseResponseDTO mapClase(Integer id) {
        if (id == null) {
            return null;
        }
        return ClaseResponseDTO.builder().id(id).build();
    }

}
