package mael.simplecodebase.dto.author;

import lombok.Getter;
import lombok.Setter;
import mael.simplecodebase.dto.person.PersonDTO;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class AuthorLightDTO extends PersonDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer age;
}
