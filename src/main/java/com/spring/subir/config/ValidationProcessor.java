package com.spring.subir.config;

import com.spring.subir.entitiy.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class ValidationProcessor implements ItemProcessor<Person, Person> {
    @Override
    public Person process(Person person) {
        //call the other api
        return person;
    }
}
