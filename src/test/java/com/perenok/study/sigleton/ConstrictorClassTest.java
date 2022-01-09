package com.perenok.study.sigleton;

import com.perenok.study.singleton.Age;
import com.perenok.study.singleton.Croffle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConstrictorClassTest {

    @Test
    @DisplayName("equals and hashcode test")
    void name() {
        Age age = new Age(29);
        Croffle croffle1 = new Croffle(1L, age, "croffle", false);
        Croffle croffle2 = new Croffle(1L, age, "croffle", false);

        assertThat(croffle1).isEqualTo(croffle2);
        assertThat(croffle1).isSameAs(croffle2);

    }
}
