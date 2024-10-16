package mael.simplecodebase.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractSModelDTO {
    private Long id;
    private String code;
    private String label;

}
