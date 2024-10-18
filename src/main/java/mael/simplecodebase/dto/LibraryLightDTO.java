package mael.simplecodebase.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;


@Getter
@Setter
public class LibraryLightDTO {
    private Long id;
    @NotNull
    private String name;
}
