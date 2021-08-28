package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.entity.Person;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {

    private static final String FIRST_NAME = "Rodrigo";
    private static final String LAST_NAME = "Peleias";
    private static final String CPF_NUMBER = "369.333.878-79";
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);
    public static final LocalDate ADMISSION_DATE = LocalDate.of(2021, 9, 1);

    public static PersonDTO createFakeDTO() {
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("04-04-2010")
                .admissionDate("01-09-2021")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .departament(DepartamentUtils.createFakeDTO())
                .salary(SalaryUtils.createFakeDTOList().get(2))
                .build();
    }

    public static Person createFakeEntity() {
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .admissionDate(ADMISSION_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .departament(DepartamentUtils.createFakeEntity())
                .salary(SalaryUtils.createFakeEntityList().get(2))
                .build();
    }
}
