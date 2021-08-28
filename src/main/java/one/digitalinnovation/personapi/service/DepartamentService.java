package one.digitalinnovation.personapi.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.dto.request.DepartamentDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Departament;
import one.digitalinnovation.personapi.exception.DepartamentNotFoundException;
import one.digitalinnovation.personapi.mapper.DepartamentMapper;
import one.digitalinnovation.personapi.repository.DepartamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DepartamentService {
    private DepartamentRepository departamentRepository;

    private final DepartamentMapper departamentMapper = DepartamentMapper.INSTANCE;

    public MessageResponseDTO createDepartament(DepartamentDTO departamentDTO) {
        Departament departamentToSave = departamentMapper.toModel(departamentDTO);

        Departament savedDepartament = departamentRepository.save(departamentToSave);
        return createMessageResponse(savedDepartament.getId(), "Created departament with ID ");
    }

    public List<DepartamentDTO> listAll() {
        List<Departament> allDepartaments = departamentRepository.findAll();
        return allDepartaments.stream()
                .map(departamentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public DepartamentDTO findById(Long id) throws DepartamentNotFoundException {
        Departament departament = verifyIfExists(id);

        return departamentMapper.toDTO(departament);
    }

    public void delete(Long id) throws DepartamentNotFoundException {
        verifyIfExists(id);
        departamentRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, DepartamentDTO departamentDTO) throws DepartamentNotFoundException {
        verifyIfExists(id);

        Departament departamentToUpdate = departamentMapper.toModel(departamentDTO);

        Departament updatedDepartament = departamentRepository.save(departamentToUpdate);
        return createMessageResponse(updatedDepartament.getId(), "Updated departament with ID ");
    }

    private Departament verifyIfExists(Long id) throws DepartamentNotFoundException {
        return departamentRepository.findById(id)
                .orElseThrow(() -> new DepartamentNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
