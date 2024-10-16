package mael.simplecodebase.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClientDTO extends PersonDTO{
    private String email;
    private List<LibraryLightDTO> libraries;
}
