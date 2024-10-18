package mael.simplecodebase.dto;

import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

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
