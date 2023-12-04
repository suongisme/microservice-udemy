package me.suongnguyen.springbootkafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messaging")
@RequiredArgsConstructor
@Slf4j
public class Controller {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @GetMapping
    public Person publishEvent(@RequestParam String name, @RequestParam int age) {
        Person person = new Person();
        person.setAge(age);
        person.setName(name);
        log.info("publish json: {}", person);
        final Message<Person> message = MessageBuilder
                .withPayload(person)
                .setHeader(KafkaHeaders.TOPIC, "first-topic")
                .build();
        this.kafkaTemplate.send(message);
        return person;
    }
}
