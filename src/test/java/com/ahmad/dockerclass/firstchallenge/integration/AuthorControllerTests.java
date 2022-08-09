package com.ahmad.dockerclass.firstchallenge.integration;

import com.ahmad.dockerclass.firstchallenge.controller.AuthorController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class AuthorControllerTests {

    @Test
    public void getAuthorTest()
    {
        AuthorController sut = new AuthorController();

        var authorResponseEntity= sut.getAuthor();

        Assertions.assertEquals(HttpStatus.OK, authorResponseEntity.getStatusCode());
        Assertions.assertEquals("Ahmad Farzaneh", authorResponseEntity.getBody());
    }
}
