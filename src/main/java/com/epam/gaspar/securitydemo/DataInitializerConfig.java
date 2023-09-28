package com.epam.gaspar.securitydemo;

import com.epam.gaspar.securitydemo.repo.Data;
import com.epam.gaspar.securitydemo.service.DataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;

@Slf4j
@Configuration
@Profile("dev")
@RequiredArgsConstructor
public class DataInitializerConfig {

    private final DataService dataService;

    @EventListener(ApplicationReadyEvent.class)
    public void initializeDevData() {
        log.info("Application ready on DEV, loading dummy data if needed");
        if(dataService.countData() == 0) {
            dataService.saveData(Data.builder()
                    .key("dev key 1")
                    .value("dev value 1")
                    .build());
            dataService.saveData(Data.builder()
                    .key("dev key 2")
                    .value("dev value 2")
                    .build());
            log.info("Dummy data loaded");
        } else {
            log.info("There was no need to load dummy data");
        }
    }

}
