package mael.simplecodebase.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class BookDTO {
    private Long id;
    private String title;
    private String description;
    private String identifiant;
    private LocalDate publicationYear;
    private AuthorLightDTO author;
    private List<LibraryLightDTO> libraries;
}
