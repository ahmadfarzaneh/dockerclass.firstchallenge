package com.ahmad.dockerclass.firstchallenge.integration;

import com.ahmad.dockerclass.firstchallenge.controller.HelloWorldController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class HelloWorldControllerTests {

    @Test
    public void getHelloWorldTest() {
        HelloWorldController sut = new HelloWorldController();

        var helloWorldResponseEntity = sut.getHelloWorld("AhmadFarzaneh");

        Assertions.assertEquals(HttpStatus.OK, helloWorldResponseEntity.getStatusCode());
        Assertions.assertEquals("Hello Ahmad Farzaneh", helloWorldResponseEntity.getBody());
    }
}
