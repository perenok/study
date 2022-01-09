package com.perenok.study.singleton;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Croffle {

    private Long id;
    private Age age;
    private String name;
    private boolean isHappy;

    public Croffle() {
    }


    public Croffle(Long id, Age age, String name, boolean isHappy) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.isHappy = isHappy;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHappy(boolean happy) {
        isHappy = happy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Croffle croffle = (Croffle) o;
        return id.equals(croffle.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Croffle{" +
                "age=" + age.getValue() +
                ", name='" + name + '\'' +
                ", isHappy=" + isHappy +
                '}';
    }
}
