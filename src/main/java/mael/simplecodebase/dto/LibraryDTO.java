package mael.simplecodebase.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LibraryDTO {
    private Long id;
    private String name;
    private List<ClientLightDTO> clients;
    private List<BookLightDTO> books;
}
