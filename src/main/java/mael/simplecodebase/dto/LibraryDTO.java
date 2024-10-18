package mael.simplecodebase.dto;

import lombok.Getter;
import lombok.Setter;
import mael.simplecodebase.dto.book.BookLightDTO;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class LibraryDTO {
    private Long id;
    @NotNull
    private String name;
    private List<ClientLightDTO> clients;
    private List<BookLightDTO> books;
}
