package mael.simplecodebase.dto.library;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;


@Getter
@Setter
public class LibraryLightDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    @NotNull
    private String name;
}
