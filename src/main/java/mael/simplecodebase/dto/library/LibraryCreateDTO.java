package mael.simplecodebase.dto.library;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class LibraryCreateDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @NotNull
    private String name;
    private List<Long> clientsIds;
    private List<Long> booksIds;
}
