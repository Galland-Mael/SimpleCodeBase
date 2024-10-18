package mael.simplecodebase.dto.book;

import lombok.Getter;
import lombok.Setter;
import mael.simplecodebase.dto.AuthorLightDTO;
import mael.simplecodebase.dto.LibraryLightDTO;
import mael.simplecodebase.dto.SettingLiteraryTypeDTO;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class BookDTO {
    private Long id;
    @NotNull
    private String title;
    private String description;
    @NotNull
    private LocalDate publicationDate;
    @NotNull
    private LocalDate writtingDate;
    @NotNull
    private AuthorLightDTO author;
    @NotNull
    private SettingLiteraryTypeDTO settingLiteraryType;
    private List<LibraryLightDTO> libraries;
}
