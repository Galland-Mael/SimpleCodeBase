package mael.simplecodebase.dto.author;


import lombok.Getter;
import lombok.Setter;
import mael.simplecodebase.dto.BookLightDTO;
import mael.simplecodebase.dto.person.PersonDTO;
import mael.simplecodebase.dto.SettingLiteraryTypeDTO;

import java.util.List;

@Getter
@Setter
public class AuthorDTO extends PersonDTO {
    private Integer age;
    private SettingLiteraryTypeDTO settingLiteraryType;
    private List<BookLightDTO> books;
}
