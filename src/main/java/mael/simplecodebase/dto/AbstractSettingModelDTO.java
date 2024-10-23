package mael.simplecodebase.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;


@Getter
@Setter
@EqualsAndHashCode
public abstract class AbstractSettingModelDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private String code;
    private String label;
}
