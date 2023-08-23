package me.suongnguyen.microservice.swagger;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "ms.swagger")
@Setter
@Getter
public class SwaggerProperties {
   private boolean enabled;

}
