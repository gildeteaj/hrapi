package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.dto.request.DepartamentDTO;
import one.digitalinnovation.personapi.entity.Departament;

public class DepartamentUtils {

    public static DepartamentDTO createFakeDTO(){
        return DepartamentDTO.builder()
                .id(1L)
                .name("Financeiro")
                .build();
    }

    public static Departament createFakeEntity() {
        return Departament.builder()
                .name("Financeiro")
                .build();
    }
}
