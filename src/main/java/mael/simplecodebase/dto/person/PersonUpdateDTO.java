package mael.simplecodebase.dto.person;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public abstract class PersonUpdateDTO {
    @NotNull
    @NotBlank
    private String firstname;
    @NotNull
    @NotBlank
    private String name;
}
