package com.perenok.study.equalsandhashcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class EqualTest {

    @Test
    void name() {
        Student student1 = new Student("크로플", 30);
        Student student2 = new Student("인비", 28);

        student2.setName("크로플");

        student1.equals(student2);

        assertThat(student1).isEqualTo(student2);
        assertThat(student1).isSameAs(student1);

        NavigableMap<Integer, String> map = new TreeMap<>();
        map.put(10, "빨강");
        map.put(5, "파랑");
        map.put(2, "초록");
        int score = (int) ((Math.random() * 10000) % 10);

        log.info("색깔 : {}, 점수 : {}", map.ceilingEntry(score), score);
     }
}
