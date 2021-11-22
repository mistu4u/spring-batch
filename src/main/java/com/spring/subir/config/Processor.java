package com.spring.subir.config;

import com.spring.subir.entitiy.Person;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

@Service
public class Processor {

    public ItemProcessor<Person, Person> processor() {
        return new ValidationProcessor();
    }

}
