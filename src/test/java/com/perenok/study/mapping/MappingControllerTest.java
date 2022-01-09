package com.perenok.study.mapping;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MappingControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setup() {
        RestAssured.port = port;
    }

    @Test
    @DisplayName("ModelAttribute 매핑 테스트")
    void createWithModelTest() {

        String jsonBody = "{" +
                "   \"name\":\"크로플\",\n" +
                "   \"age\":\"29\"\n" +
                "}";

        RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .and()
                .body(jsonBody)
                .when().post("/mapping/model")
                .then().log().all()
                .extract();
    }

    @Test
    @DisplayName("RequestBody 매핑 테스트")
    void createWithBodyTest() {

        String jsonBody = "{" +
                "   \"name\":\"크로플\",\n" +
                "   \"age\":\"29\"\n" +
                "}";

        RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .and()
                .body(jsonBody)
                .when().post("/mapping/body")
                .then().log().all()
                .extract();
    }
}
