package com.ahmad.dockerclass.firstchallenge.controller;

import com.ahmad.dockerclass.firstchallenge.model.HelloWorld;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

   @GetMapping("/helloworld{name}")
    public ResponseEntity<String> getHelloWorld(@RequestParam(required = false) String name)
    {
        var message = new HelloWorld(name).getMessage();
        return ResponseEntity.ok(message);
    }
}
