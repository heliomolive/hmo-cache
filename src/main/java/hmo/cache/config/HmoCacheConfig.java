package hmo.cache.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource(value = "classpath:/application.properties", encoding = "UTF-8")
})
public class HmoCacheConfig {
}
