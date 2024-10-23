package mael.simplecodebase.dto.author;


import lombok.Getter;
import lombok.Setter;
import mael.simplecodebase.dto.person.PersonUpdateDTO;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class AuthorUpdateDTO extends PersonUpdateDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer age;
    private List<Long> booksIds;
}
