package one.digitalinnovation.personapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.enums.RoleLevel;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalaryDTO {
    private Long id;

    private RoleDTO role;

    @Enumerated(EnumType.STRING)
    private RoleLevel roleLevel;

    @NotNull
    @Min(6)
    private Integer hoursDay;

    @NotNull
    private Double salary;

}
