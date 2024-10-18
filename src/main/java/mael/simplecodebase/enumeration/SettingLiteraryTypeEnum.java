package mael.simplecodebase.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SettingLiteraryTypeEnum implements CodeEnum {
    FICTION("FICTION"),
    POETRY("POETRY"),
    DRAMA("DRAMA"),
    SCIENCE_FICTION("SCIENCE_FICTION"),
    FANTASY("FANTASY"),
    MYSTERY("MYSTERY"),
    HISTORICAL("HISTORICAL"),
    ROMANCE("ROMANCE"),
    THRILLER("THRILLER");

    private String code;
}
