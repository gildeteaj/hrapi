package one.digitalinnovation.personapi.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartamentDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String name;
}
