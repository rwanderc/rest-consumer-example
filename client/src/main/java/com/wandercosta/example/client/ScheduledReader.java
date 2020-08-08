package com.wandercosta.example.client;

import java.net.URI;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class ScheduledReader {

    private final RestTemplate restTemplate;

    public ScheduledReader(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Scheduled(fixedDelay = 10_000)
    public void loadSchoolsFromOtherService() {
        final URI schoolsUri = URI.create("http://localhost:8080/schools");
        final School[] schoolsArr = restTemplate.getForObject(schoolsUri, School[].class);
        final List<School> schools = List.of(schoolsArr);
        log.info("Schools received from service: {}", schools);
    }
}
