package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cibertec.skilling.backend.model.dto.request.AnuncioRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.AnuncioResponseDTO;
import com.cibertec.skilling.backend.model.entity.Anuncio;

@Mapper(componentModel = "spring")
public interface AnuncioMapper {

    @Mapping(target = "clase.id", source = "claseId")
    Anuncio toEntity(AnuncioRequestDTO requestDTO);

    @Mapping(source= "clase.id", target = "claseId")
    AnuncioResponseDTO toResponseDTO(Anuncio anuncio);
}
