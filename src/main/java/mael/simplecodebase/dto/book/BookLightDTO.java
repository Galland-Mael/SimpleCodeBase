package mael.simplecodebase.dto.book;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class BookLightDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    @NotNull
    private String title;
    private String description;
    @NotNull
    private LocalDate publicationDate;
    @NotNull
    private LocalDate writtingDate;

}
