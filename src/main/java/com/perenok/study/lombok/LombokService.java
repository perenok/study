package com.perenok.study.lombok;

import java.time.LocalDate;

public class LombokService {

    public static void main(String[] args) {
        show();
    }

    public static void show() {
        Student student = Student.builder()
                .id(1L)
                .name("크로플")
                .age(29)
                .dateOfBirth(LocalDate.now())
                .graduated(true)
                .build();
        System.out.println(student.toString());
    }
}
