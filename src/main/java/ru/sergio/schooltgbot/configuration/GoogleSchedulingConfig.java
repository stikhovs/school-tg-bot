package ru.sergio.schooltgbot.configuration;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.net.HttpURLConnection;
import java.net.URL;

@Slf4j
/*@Configuration
@EnableScheduling*/
public class GoogleSchedulingConfig {

    @SneakyThrows
    //@Scheduled(fixedRate = 600000L) // 10 min
    public void pingGoogle() {
            URL url = new URL("https://www.google.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            log.info("Ping {}, OK: response code {}", url.getHost(), connection.getResponseCode());
            connection.disconnect();
    }

}
