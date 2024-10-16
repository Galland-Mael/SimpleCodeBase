package mael.simplecodebase.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorLightDTO extends PersonDTO {
    private Integer age;
    private SLiteraryTypeDTO literaryGenre;
}
