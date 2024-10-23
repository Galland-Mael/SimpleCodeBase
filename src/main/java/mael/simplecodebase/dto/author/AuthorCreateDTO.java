package mael.simplecodebase.dto.author;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import mael.simplecodebase.dto.person.PersonCreateDTO;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class AuthorCreateDTO extends PersonCreateDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @NotNull
    private Integer age;
    private List<Long> booksIds;
}
