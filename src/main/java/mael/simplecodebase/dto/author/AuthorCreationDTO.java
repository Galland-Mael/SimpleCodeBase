package mael.simplecodebase.dto.author;


import lombok.Getter;
import lombok.Setter;
import mael.simplecodebase.dto.person.PersonCreationDTO;
import mael.simplecodebase.enumeration.SettingLiteraryTypeEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class AuthorCreationDTO extends PersonCreationDTO {
    @NotNull
    @NotBlank
    private Integer age;
    private List<Long> booksId;
}
