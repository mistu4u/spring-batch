package com.spring.subir.config;

import com.spring.subir.entitiy.Person;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Service;


@Service
public class Writer  {

    public ItemWriter<Person> writer() {
        return new CustomWriter();
    }

}
