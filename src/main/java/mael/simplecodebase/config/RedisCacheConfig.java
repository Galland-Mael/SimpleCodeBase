package mael.simplecodebase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;
import java.util.Map;

@Configuration
public class RedisCacheConfig {

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {

        Map<String, RedisCacheConfiguration> cacheConfigurations = Map.of(
                CacheName.SETTING_LITERARY_TYPE_DTO, cacheConfigurationWithTtl(CacheTimeEnum.CACHE_7J)
        );

        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(cacheConfiguration())
                .withInitialCacheConfigurations(cacheConfigurations)
                .build();
    }

    public RedisCacheConfiguration cacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig();
    }

    public RedisCacheConfiguration cacheConfigurationWithTtl(long ttl) {
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(ttl));
    }
}
