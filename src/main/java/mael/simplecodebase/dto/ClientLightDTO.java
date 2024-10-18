package mael.simplecodebase.dto;

import lombok.Getter;
import lombok.Setter;
import mael.simplecodebase.dto.person.PersonDTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


@Getter
@Setter
public class ClientLightDTO extends PersonDTO {
    @NotNull
    @Email
    private String email;
}
