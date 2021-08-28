package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.request.DepartamentDTO;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.request.RoleDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Departament;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.entity.Role;
import one.digitalinnovation.personapi.repository.DepartamentRepository;
import one.digitalinnovation.personapi.repository.PersonRepository;
import one.digitalinnovation.personapi.repository.RoleRepository;
import one.digitalinnovation.personapi.utils.DepartamentUtils;
import one.digitalinnovation.personapi.utils.PersonUtils;
import one.digitalinnovation.personapi.utils.RoleUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.personapi.utils.PersonUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private DepartamentRepository deptoRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        Role expectedSavedRole = RoleUtils.createFakeEntity();
        Departament expectedSavedDepto = DepartamentUtils.createFakeEntity();

        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        roleRepository.save(expectedSavedRole);
        deptoRepository.save(expectedSavedDepto);
        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPerson.getId());
        MessageResponseDTO succesMessage = personService.createPerson(personDTO);

        assertEquals(expectedSuccessMessage, succesMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + id)
                .build();
    }
}
