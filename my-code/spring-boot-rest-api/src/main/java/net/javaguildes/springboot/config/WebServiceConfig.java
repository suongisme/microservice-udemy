package net.javaguildes.springboot.config;

import lombok.RequiredArgsConstructor;
import net.javaguildes.springboot.interceptor.ClientIdInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@RequiredArgsConstructor
public class WebServiceConfig implements WebMvcConfigurer {

    private final ClientIdInterceptor clientIdInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.clientIdInterceptor)
                .addPathPatterns("/**");
    }
}
