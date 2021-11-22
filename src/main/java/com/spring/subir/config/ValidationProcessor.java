package com.spring.subir.config;

import com.spring.subir.entitiy.Person;
import org.springframework.batch.item.ItemProcessor;

public class ValidationProcessor implements ItemProcessor<Person, Person> {
    @Override
    public Person process(Person person) {
        System.out.println(person.getPhoneNo());
        return person;
    }
}
