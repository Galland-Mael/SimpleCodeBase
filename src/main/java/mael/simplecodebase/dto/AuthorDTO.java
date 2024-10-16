package mael.simplecodebase.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuthorDTO extends PersonDTO {
    private Integer age;
    @JsonProperty("sLiteraryType")
    private SLiteraryTypeDTO sLiteraryType;
    private List<BookLightDTO> books;
}
