package one.digitalinnovation.personapi.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.dto.request.DepartamentDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.exception.DepartamentNotFoundException;
import one.digitalinnovation.personapi.service.DepartamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/departament")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DepartamentController {
    private DepartamentService departamentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createDepartament(@RequestBody @Valid DepartamentDTO departamentDTO) {
        return departamentService.createDepartament(departamentDTO);
    }

    @GetMapping
    public List<DepartamentDTO> listAll() {
        return departamentService.listAll();
    }

    @GetMapping("/{id}")
    public DepartamentDTO findById(@PathVariable Long id) throws DepartamentNotFoundException {
        return departamentService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid DepartamentDTO departamentDTO) throws DepartamentNotFoundException {
        return departamentService.updateById(id, departamentDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws DepartamentNotFoundException {
        departamentService.delete(id);
    }
}
