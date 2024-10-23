package mael.simplecodebase.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CacheName {

    private final String name;

    public static final String SETTING_LITERARY_TYPE_DTO = "settingLiteraryTypeDTO";
}
