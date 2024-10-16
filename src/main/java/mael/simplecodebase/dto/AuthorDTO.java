package mael.simplecodebase.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuthorDTO extends PersonDTO {
    private Integer age;
    private SLiteraryTypeDTO literaryGenre;
    private List<BookLightDTO> books;
}
