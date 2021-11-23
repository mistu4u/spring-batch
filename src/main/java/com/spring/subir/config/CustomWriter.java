package com.spring.subir.config;

import com.spring.subir.entitiy.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

@Slf4j
public class CustomWriter implements ItemWriter<Person> {
    @Override
    public void write(List<? extends Person> list) {
        log.info("Record processed is => {}", list);
    }
}
