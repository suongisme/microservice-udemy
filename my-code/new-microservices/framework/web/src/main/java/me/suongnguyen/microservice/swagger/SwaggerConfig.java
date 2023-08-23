package me.suongnguyen.microservice.swagger;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@ConditionalOnProperty(
        prefix = "ms.swagger",
        name = "enabled",
        havingValue = "true",
        matchIfMissing = true
)
public class SwaggerConfig {
}
