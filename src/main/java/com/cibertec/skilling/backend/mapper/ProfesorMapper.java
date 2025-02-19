package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cibertec.skilling.backend.model.dto.request.ProfesorRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.ProfesorResponseDTO;
import com.cibertec.skilling.backend.model.dto.response.RolResponseDTO;
import com.cibertec.skilling.backend.model.dto.response.UsuarioResponseDTO;
import com.cibertec.skilling.backend.model.entity.Profesor;
import com.cibertec.skilling.backend.model.entity.Rol;
import com.cibertec.skilling.backend.model.entity.Usuario;

@Mapper(componentModel = "spring")
public interface ProfesorMapper {

    @Mapping(target = "usuarioRef.id", source = "usuarioId")
    Profesor toEntity(ProfesorRequestDTO requestDTO);

    @Mapping(source = "usuarioRef", target = "usuarioId")
    ProfesorResponseDTO toResponseDTO(Profesor profesor);

    @Mapping(source = "rol", target = "rolId")
    UsuarioResponseDTO toUsuarioResponseDTO(Usuario usaurio);

    RolResponseDTO toRolResponseDTO(Rol rol);
}
