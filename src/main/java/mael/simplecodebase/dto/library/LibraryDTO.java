package mael.simplecodebase.dto.library;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import mael.simplecodebase.dto.client.ClientLightDTO;
import mael.simplecodebase.dto.book.BookLightDTO;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class LibraryDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    @NotNull
    private String name;
    private List<ClientLightDTO> clients;
    private List<BookLightDTO> books;
}
