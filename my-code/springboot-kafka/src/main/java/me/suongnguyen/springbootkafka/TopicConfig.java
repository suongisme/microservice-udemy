package me.suongnguyen.springbootkafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {

    @Bean
    public NewTopic firstTopic() {
        return TopicBuilder.name("first-topic")
                .build();
    }
}
