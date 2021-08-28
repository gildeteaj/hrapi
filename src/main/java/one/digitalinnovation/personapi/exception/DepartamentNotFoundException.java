package one.digitalinnovation.personapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DepartamentNotFoundException extends Exception{
    public DepartamentNotFoundException(Long id) {
        super("Departament not found with ID " + id);
    }
}
