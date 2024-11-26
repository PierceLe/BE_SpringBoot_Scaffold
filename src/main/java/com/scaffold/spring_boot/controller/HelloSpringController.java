package com.scaffold.spring_boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringController {
    @GetMapping("/hello")
    String sayHello() {
        return "Hello Spring Boot 3!";
    }
}