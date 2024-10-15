package mael.simplecodebase.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import mael.simplecodebase.model.Book;
import mael.simplecodebase.model.Client;

import java.util.List;

@Getter
@Setter
public class LibraryDTO {
    private Long id;
    private String name;
    private List<ClientLightDTO> clients;
    private List<BookLightDTO> books;
}
