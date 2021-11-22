package com.spring.subir.config;

import com.spring.subir.entitiy.Person;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class PersonFieldSetMapper implements FieldSetMapper<Person> {
    @Override
    public Person mapFieldSet(FieldSet fieldSet) throws BindException {
        return Person.builder()
                .name(fieldSet.readString(0))
                .phoneNo(fieldSet.readString(1))
                .build();
    }
}
