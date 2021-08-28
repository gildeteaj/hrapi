package one.digitalinnovation.personapi.mapper;

import one.digitalinnovation.personapi.dto.request.DepartamentDTO;
import one.digitalinnovation.personapi.entity.Departament;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartamentMapper {
    DepartamentMapper INSTANCE = Mappers.getMapper(DepartamentMapper.class);


    Departament toModel(DepartamentDTO personDTO);

    DepartamentDTO toDTO(Departament person);
}
