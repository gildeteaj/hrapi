package one.digitalinnovation.personapi.repository;

import one.digitalinnovation.personapi.entity.Departament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentRepository extends JpaRepository<Departament, Long> {
}
