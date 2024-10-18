package mael.simplecodebase.dto.book;

import lombok.Getter;
import lombok.Setter;
import mael.simplecodebase.enumeration.SettingLiteraryTypeEnum;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class BookCreationDTO {
    private Long id;
    @NotNull
    private String title;
    private String description;
    @NotNull
    private LocalDate publicationDate;
    @NotNull
    private LocalDate writtingDate;
    @NotNull
    private Long authorId;
    @NotNull
    private SettingLiteraryTypeEnum settingLiteraryType;
    private List<Long> librariesIds;
}
