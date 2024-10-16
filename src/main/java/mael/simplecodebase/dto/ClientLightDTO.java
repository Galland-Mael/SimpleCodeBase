package mael.simplecodebase.dto;

import lombok.Getter;
import lombok.Setter;
import mael.simplecodebase.dto.person.PersonDTO;


@Getter
@Setter
public class ClientLightDTO extends PersonDTO {
    private String email;
}
