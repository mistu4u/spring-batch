package com.spring.subir.entitiy;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Person {
    private String name;
    private String phoneNo;
}
