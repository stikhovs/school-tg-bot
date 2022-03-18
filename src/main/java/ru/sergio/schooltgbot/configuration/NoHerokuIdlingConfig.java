package ru.sergio.schooltgbot.configuration;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Configuration
@EnableScheduling
public class NoHerokuIdlingConfig {

    @SneakyThrows
    @Scheduled(fixedRate = 900000L) // 15 min
    public void pingGoogle() {
        RestTemplate restTemplate = new RestTemplate();
        Object obj = restTemplate.getForObject("https://school-tg-bot.herokuapp.com/actuator/health", Object.class);
        log.info("Self ping {}", obj);
    }

}
