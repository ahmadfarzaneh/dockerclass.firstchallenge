package com.ahmad.dockerclass.firstchallenge.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @GetMapping("/author")
    public ResponseEntity<String> getAuthor()
    {
        return ResponseEntity.ok("Ahmad Farzaneh");
    }
}
