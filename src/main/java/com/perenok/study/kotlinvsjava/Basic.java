package com.perenok.study.kotlinvsjava;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Basic {

    public static void main(String[] args) {
        Student 크로플 = new Student("크로플", 30);

        var student = 크로플;

        log.info("{}", student);
    }
}
