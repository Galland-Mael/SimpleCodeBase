package mael.simplecodebase.dto;

import lombok.Getter;
import lombok.Setter;
import mael.simplecodebase.dto.person.PersonDTO;

import java.util.List;

@Getter
@Setter
public class ClientDTO extends PersonDTO {
    private String email;
    private List<LibraryLightDTO> libraries;
}
