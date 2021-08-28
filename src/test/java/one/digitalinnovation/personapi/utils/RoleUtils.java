package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.dto.request.RoleDTO;
import one.digitalinnovation.personapi.entity.Role;

public class RoleUtils {
    public static RoleDTO createFakeDTO(){
        return RoleDTO.builder()
                .id(1L)
                .name("Desenvolvedor")
                .requirements("Java")
                .salaries(SalaryUtils.createFakeDTOList())
                .build();
    }

    public static Role createFakeEntity(){
        return Role.builder()
                .id(1L)
                .name("Desenvolvedor")
                .requirements("Java")
                .salaries(SalaryUtils.createFakeEntityList())
                .build();
    }

    public static RoleDTO createFakeDTO2(){
        return RoleDTO.builder()
                .id(1L)
                .name("Desenvolvedor")
                .requirements("Java")
                .build();

    }

    public static Role createFakeEntity2(){
        return Role.builder()
                .id(1L)
                .name("Desenvolvedor")
                .requirements("Java")
                .build();
    }

}
