package com.spring.subir.config;

import com.spring.subir.entitiy.Person;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class CustomWriter implements ItemWriter<Person> {
    @Override
    public void write(List<? extends Person> list) throws Exception {
        System.out.println(list);
    }
}
