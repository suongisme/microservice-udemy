package net.javaguildes.springboot;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class SpringBootRestApiApplication implements InitializingBean {

    @Value("${app.time-zone}")
    private String timeZone;

    @Override
    public void afterPropertiesSet() throws Exception {
        TimeZone.setDefault(TimeZone.getTimeZone(this.timeZone));
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestApiApplication.class, args);
    }
}
