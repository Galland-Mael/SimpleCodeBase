package mael.simplecodebase.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode
public abstract class AbstractSModelDTO {
    private Long id;
    private String code;
    private String label;
}
