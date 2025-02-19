package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cibertec.skilling.backend.model.dto.request.AdministradorRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.AdministradorResponseDTO;
import com.cibertec.skilling.backend.model.dto.response.RolResponseDTO;
import com.cibertec.skilling.backend.model.dto.response.UsuarioResponseDTO;
import com.cibertec.skilling.backend.model.entity.Administrador;
import com.cibertec.skilling.backend.model.entity.Rol;
import com.cibertec.skilling.backend.model.entity.Usuario;

@Mapper(componentModel = "spring")
public interface AdministradorMapper {

    @Mapping(target = "usuarioRef.id", source = "usuarioId")
    Administrador toEntity(AdministradorRequestDTO requestDTO);

    @Mapping(source = "usuarioRef", target = "usuarioId")
    AdministradorResponseDTO toResponseDTO(Administrador administrador);

    @Mapping(source = "rol", target = "rolId")
    UsuarioResponseDTO toUsuarioResponseDTO(Usuario usuario);

    RolResponseDTO toRolResponseDTO(Rol rol);
}
