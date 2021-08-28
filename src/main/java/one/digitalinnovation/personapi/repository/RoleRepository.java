package one.digitalinnovation.personapi.repository;

import one.digitalinnovation.personapi.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
