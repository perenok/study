package com.perenok.study.singleton;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConstructorClass {

    public static void testRun(){
        Age age = new Age();
        Croffle croffle = new Croffle(1L, age, "croffle", false);
        String name = croffle.getName();
        List<String> list = new ArrayList<>();
        List<String> list2 = new LinkedList<>();

        System.out.println(croffle.toString());
    }

    public static void main(String[] args) {
        testRun();
    }
}
