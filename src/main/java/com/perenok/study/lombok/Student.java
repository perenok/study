package com.perenok.study.lombok;

import lombok.Builder;
import lombok.ToString;

import java.time.LocalDate;

@ToString
public class Student {

    private Long id;
    private String name;
    private int age;
    private LocalDate dateOfBirth;
    private boolean graduated;

    @Builder
    public Student(
            Long id, String name,
            int age, LocalDate dateOfBirth,
            boolean graduated
    ) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.graduated = graduated;
    }
}
