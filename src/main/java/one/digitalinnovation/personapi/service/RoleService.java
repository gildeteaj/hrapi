package one.digitalinnovation.personapi.service;


import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.dto.request.RoleDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Role;
import one.digitalinnovation.personapi.exception.RoleNotFoundException;
import one.digitalinnovation.personapi.mapper.RoleMapper;
import one.digitalinnovation.personapi.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RoleService {

    private RoleRepository roleRepository;

    private final RoleMapper roleMapper = RoleMapper.INSTANCE;

    public MessageResponseDTO createRole(RoleDTO roleDTO) {
        Role roleToSave = roleMapper.toModel(roleDTO);

        Role savedRole = roleRepository.save(roleToSave);
        return createMessageResponse(savedRole.getId(), "Created role with ID ");
    }

    public List<RoleDTO> listAll() {
        List<Role> allRoles = roleRepository.findAll();
        return allRoles.stream()
               .map(roleMapper::toDTO)
               .collect(Collectors.toList());
    }

    public RoleDTO findById(Long id) throws RoleNotFoundException {
        Role role = verifyIfExists(id);

        return roleMapper.toDTO(role);
    }

    public void delete(Long id) throws RoleNotFoundException {
        verifyIfExists(id);
        roleRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, RoleDTO roleDTO) throws RoleNotFoundException {
        verifyIfExists(id);

        Role roleToUpdate = roleMapper.toModel(roleDTO);

        Role updatedRole = roleRepository.save(roleToUpdate);
        return createMessageResponse(updatedRole.getId(), "Updated role with ID ");
    }

    private Role verifyIfExists(Long id) throws RoleNotFoundException {
        return roleRepository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

}
