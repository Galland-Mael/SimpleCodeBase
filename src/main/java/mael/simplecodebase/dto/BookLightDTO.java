package mael.simplecodebase.dto;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import mael.simplecodebase.model.Author;
import mael.simplecodebase.model.Library;

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
//    private List<Library> libraries;
}
