package com.example.demo.Batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;

@Slf4j
@Configuration
public class BatchConfig {

    // JOB 단위 생성(step1 -> step2 실행)
    @Bean
    public Job basicJob(
            JobRepository jobRepository,
            Step step1,
            Step step2
    ) {
        return new JobBuilder("basicJob",jobRepository)
                .start(step1)
                .next(step2)
                .build();
    }

    // step1
    @Bean
    public Step step1(JobRepository jobRepository, JpaTransactionManager tx) {
        return new StepBuilder("step1",jobRepository)
                .tasklet((contribution,chunkContext)->{
                    // contribution : status 상태값 보관
                    // chunkContext : chunk 처리(chunk 간 연결)
                    log.info("[STEP1] - hello world batch ..");
                    return RepeatStatus.FINISHED;
                },tx)
                .build();
    }
    // step2
    @Bean
    public Step step2(JobRepository jobRepository, JpaTransactionManager tx) {
        return new StepBuilder("step2",jobRepository)
                .tasklet((contribution,chunkContext)->{
                    // contribution : status 상태값 보관
                    // chunkContext : chunk 처리(chunk 간 연결)
                    for(int i=1;i<=5;i++)
                        log.info("[STEP2] - hello world batch .." + i);

                    return RepeatStatus.FINISHED;
                },tx)
                .build();
    }
}
