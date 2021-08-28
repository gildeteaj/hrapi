package one.digitalinnovation.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleLevel {

    JUNIOR("Junior"),
    MID("Mid-Level"),
    SENIOR("Senior");

    private final String description;
}
