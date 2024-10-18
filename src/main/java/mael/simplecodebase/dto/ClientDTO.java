package mael.simplecodebase.dto;

import lombok.Getter;
import lombok.Setter;
import mael.simplecodebase.dto.person.PersonDTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class ClientDTO extends PersonDTO {
    @NotNull
    @Email
    private String email;
    private List<LibraryLightDTO> libraries;
}
