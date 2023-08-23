package me.suongnguyen.employeeservice.config;

import me.suongnguyen.commonmodel.constant.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.List;

@Configuration
public class WebConfig {

    @Bean
    public LocaleResolver localeResolver() {
        final AcceptHeaderLocaleResolver resolver = new AcceptHeaderLocaleResolver();
        resolver.setSupportedLocales(List.of(Locale.EN, Locale.VI));
        resolver.setDefaultLocale(Locale.EN);
        return resolver;
    }
}
