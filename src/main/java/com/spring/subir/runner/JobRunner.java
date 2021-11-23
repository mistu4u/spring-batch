package com.spring.subir.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JobRunner {
    @Value("${spring.batch.job.enabled}")
    private String isEnabled;
    @Autowired
    private JobLauncher jobLauncher;


    @Autowired
    private Job job;

    @Bean
    @Scheduled(cron="${cron.expression}")
    public JobExecution run() {
        JobExecution jobExecution = null;
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis()).toJobParameters();

            jobExecution = jobLauncher.run(job, jobParameters);
            log.info(isEnabled);
            log.info("Exit Status : " + jobExecution.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jobExecution;
    }
}
