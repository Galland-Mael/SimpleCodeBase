package mael.simplecodebase.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CacheTimeEnum {
    private final long time;

    public static final long CACHE_7J = 604800;
    public static final long CACHE_1J = 86400;
    public static final long CACHE_1H = 3600;
    public static final long CACHE_30M = 1800;
}
