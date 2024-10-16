package mael.simplecodebase.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BookLightDTO {
    private Long id;
    private String title;
    private String description;
    private String identifiant;
    private LocalDate publicationYear;
}
