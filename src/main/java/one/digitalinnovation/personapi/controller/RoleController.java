package one.digitalinnovation.personapi.controller;


import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.dto.request.RoleDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.exception.RoleNotFoundException;
import one.digitalinnovation.personapi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RoleController {

    private RoleService roleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createRole(@RequestBody @Valid RoleDTO roleDTO) {
        return roleService.createRole(roleDTO);
    }

    @GetMapping
    public List<RoleDTO> listAll() {
        return roleService.listAll();
    }

    @GetMapping("/{id}")
    public RoleDTO findById(@PathVariable Long id) throws RoleNotFoundException {
        return roleService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid RoleDTO roleDTO) throws RoleNotFoundException {
        return roleService.updateById(id, roleDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws RoleNotFoundException {
        roleService.delete(id);
    }
}
