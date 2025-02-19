package com.cibertec.skilling.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cibertec.skilling.backend.controller.helper.PasswordEncoderMapper;
import com.cibertec.skilling.backend.model.dto.request.UsuarioRequestDTO;
import com.cibertec.skilling.backend.model.dto.response.RolResponseDTO;
import com.cibertec.skilling.backend.model.dto.response.UsuarioResponseDTO;
import com.cibertec.skilling.backend.model.entity.Rol;
import com.cibertec.skilling.backend.model.entity.Usuario;

@Mapper(componentModel = "spring", uses = {PasswordEncoderMapper.class})
public interface UsuarioMapper {

    @Mapping(target = "rol.id", source = "rolId")
    @Mapping(target = "clave", source = "clave", qualifiedByName = "encodePassword")
    Usuario toEntity(UsuarioRequestDTO requestDTO);

    @Mapping(source = "rol", target = "rolId")
    UsuarioResponseDTO toResponseDTO(Usuario usuario);

    @Mapping(source = "rol", target = "rolId")
    UsuarioResponseDTO toUsuarioResponseDTO(Usuario usuario);

    default RolResponseDTO toRolResponseDTO(Rol rol) {
        if (rol == null) {
            return null;
        }
        return RolResponseDTO.builder()
            .id(rol.getId())
            .tipo(rol.getTipo())
            .build();
    }
}
