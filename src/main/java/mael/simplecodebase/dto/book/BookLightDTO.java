package mael.simplecodebase.dto.book;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import mael.simplecodebase.dto.SettingLiteraryTypeDTO;
import mael.simplecodebase.validator.annotation.BookConstraint;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@BookConstraint
public class BookLightDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    @NotNull
    private String title;
    private String description;
    @NotNull
    private LocalDate publicationDate;
    @NotNull
    private SettingLiteraryTypeDTO settingLiteraryType;
    @NotNull
    private LocalDate writtingDate;

}
