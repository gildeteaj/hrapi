package one.digitalinnovation.personapi.mapper;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.request.RoleDTO;
import one.digitalinnovation.personapi.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);


    Role toModel(RoleDTO roleDTO);

    RoleDTO toDTO(Role role);
}
