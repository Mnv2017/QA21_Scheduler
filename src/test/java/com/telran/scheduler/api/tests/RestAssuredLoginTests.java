package com.telran.scheduler.api.tests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.telran.scheduler.api.dto.AuthRequestDto;
import com.telran.scheduler.api.dto.AuthResponseDto;
import com.telran.scheduler.api.dto.ErrorDto;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredLoginTests {

    @BeforeMethod
    public void ensurePreconditions() {
        RestAssured.baseURI = "https://super-scheduler-app.herokuapp.com/";
        RestAssured.basePath = "api";
    }

    @Test
    public void loginSuccessTest() {
        AuthRequestDto requestDto = AuthRequestDto.builder()
                .email("mnv@mail.com")
                .password("Qwerty12345$")
                .build();

        AuthResponseDto responseDto = given()
                .contentType("application/json")
                .body(requestDto)
                .when()
                .post("login")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(AuthResponseDto.class);

        System.out.println("*** " + responseDto.getToken());
        System.out.println(responseDto.getStatus());
        System.out.println(responseDto.isRegistration());
    }

    @Test
    public void loginWrongPasswordTest() {
        AuthRequestDto requestDto = AuthRequestDto.builder()
                .email("neuer@gmail.com")
                .password("euer2021")
                .build();

        String message = given()
                .contentType(ContentType.JSON)
                .body(requestDto)
                .when()
                .post("login")
                .then()
                .assertThat().statusCode(401)
                .extract().path("message");
        System.out.println("*** " + message);
    }

    @Test
    public void registrationSuccessTest() {
        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        AuthRequestDto requestDto = AuthRequestDto.builder()
                .email("neuer" + index + "@gmail.com")
                .password("Neuer2021")
                .build();

                given()
                .contentType(ContentType.JSON)
                .body(requestDto)
                .when()
                .post("login")
                .then()
                .statusCode(200)
                .assertThat().body("status", containsString("Registration success"))
                .body("registration", equalTo(true));
    }

}
