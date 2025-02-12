package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cibertec.skilling.backend.model.dto.request.UsuarioRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.UsuarioResponseDTO;
import com.cibertec.skilling.backend.model.entity.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "rol.id", source = "rolId")
    Usuario toEntity(UsuarioRequestDTO requestDTO);

    @Mapping(source = "rol.id", target = "rolId")
    UsuarioResponseDTO toResponseDTO(Usuario usuario);
}
