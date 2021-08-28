package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.dto.request.SalaryDTO;
import one.digitalinnovation.personapi.entity.Salary;
import one.digitalinnovation.personapi.enums.RoleLevel;

import java.util.ArrayList;
import java.util.List;

public class SalaryUtils {

    public static List<SalaryDTO> createFakeDTOList(){
        List<SalaryDTO> dtos = new ArrayList<>();
        dtos.add(SalaryDTO.builder()
                .id(1L)
                .roleLevel(RoleLevel.JUNIOR)
                .salary(3.0)
                .hoursDay(8)
                .build());
        dtos.add(SalaryDTO.builder()
                .id(2L)
                .roleLevel(RoleLevel.MID)
                .salary(5.0)
                .hoursDay(8)
                .build());
        dtos.add(SalaryDTO.builder()
                .id(3L)
                .roleLevel(RoleLevel.SENIOR)
                .salary(8.0)
                .hoursDay(8)
                .build());
        return dtos;
    }


    public static List<Salary> createFakeEntityList(){
        List<Salary> salaries = new ArrayList<>();
        salaries.add(Salary.builder()
                .id(1L)
                .roleLevel(RoleLevel.JUNIOR)
                .salary(3.00)
                .hoursDay(8)
                .build());
        salaries.add(Salary.builder()
                .id(2L)
                .roleLevel(RoleLevel.MID)
                .salary(5.00)
                .hoursDay(8)
                .build());
        salaries.add(Salary.builder()
                .id(3L)
                .roleLevel(RoleLevel.SENIOR)
                .salary(8.00)
                .hoursDay(8)
                .build());
        return salaries;
    }
}
