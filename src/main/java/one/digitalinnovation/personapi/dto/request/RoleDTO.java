package one.digitalinnovation.personapi.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {
    private Long id;

    @NotEmpty
    @Size(max = 100)
    private String name;

    @NotEmpty
    @Size(min = 10, max = 500)
    private String requirements;

    @Valid
    @NotEmpty
    private List<SalaryDTO> salaries;

}
