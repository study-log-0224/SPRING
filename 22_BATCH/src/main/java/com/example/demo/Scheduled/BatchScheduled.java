package com.example.demo.Scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
public class BatchScheduled {
    @Autowired
    Job basicJob;
    @Autowired
    JobLauncher jobLauncher;

    @Scheduled(initialDelay = 3000, fixedDelay = 10000)
    public void batchScheduled_1() throws Exception {
        log.info("batchScheduled_1 invoke...");

        JobParameters params = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();

        jobLauncher.run(basicJob, params);
    }
}
