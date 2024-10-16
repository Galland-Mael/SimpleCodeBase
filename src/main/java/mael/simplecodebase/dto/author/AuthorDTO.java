package mael.simplecodebase.dto.author;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import mael.simplecodebase.dto.BookLightDTO;
import mael.simplecodebase.dto.person.PersonDTO;
import mael.simplecodebase.dto.SLiteraryTypeDTO;

import java.util.List;

@Getter
@Setter
public class AuthorDTO extends PersonDTO {
    private Integer age;
    @JsonProperty("sLiteraryType")
    private SLiteraryTypeDTO sLiteraryType;
    private List<BookLightDTO> books;
}
