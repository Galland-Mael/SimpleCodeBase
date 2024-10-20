package mael.simplecodebase.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;


@Getter
@Setter
public class SettingLiteraryTypeDTO extends AbstractSettingModelDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
