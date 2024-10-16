package mael.simplecodebase.dto.person;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public abstract class PersonDTO {
    private Long id;
    @NotNull
    @NotBlank
    private String firstname;
    @NotNull
    @NotBlank
    private String name;
}
