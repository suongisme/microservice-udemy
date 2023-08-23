package me.suongnguyen.commonmodel.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class I18nConfig {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:lang/messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(60);
        return messageSource;
    }
}
