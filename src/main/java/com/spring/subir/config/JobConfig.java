package com.spring.subir.config;

import com.spring.subir.entitiy.Person;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private Reader reader;

    @Autowired
    private Processor processor;

    @Autowired
    private Writer writer;

    @Bean
    public Step step1() {
        return stepBuilderFactory
                .get("step1")
                .<Person, Person>chunk(1)
                .reader(reader.read())
                .processor(processor.processor())
                .writer(writer.writer())
                .build();
    }

    @Bean
    public Job readCSVFilesJob() {
        return jobBuilderFactory
                .get("readCSVFilesJob")
                .incrementer(new RunIdIncrementer())
                .start(step1())
                .build();
    }
}
