package mael.simplecodebase.dto.book;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import mael.simplecodebase.dto.author.AuthorLightDTO;
import mael.simplecodebase.dto.LibraryLightDTO;
import mael.simplecodebase.dto.SettingLiteraryTypeDTO;
import mael.simplecodebase.validator.annotation.BookConstraint;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@BookConstraint
public class BookDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
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
