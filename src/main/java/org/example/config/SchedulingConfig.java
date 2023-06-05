package org.example.config;

import lombok.extern.slf4j.Slf4j;
import org.example.error.NotFoundError;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@Slf4j
@EnableAsync
@EnableScheduling
public class SchedulingConfig {

    @Async
    @Scheduled(fixedRate = 2000)
    protected void SchedulingTest() throws InterruptedException, NotFoundError {
        log.info("SchedulingTest_start");
        Thread.sleep(1000);
        log.info("SchedulingTest_end");

        throw new NotFoundError("SchedulingTest");
    }


}
