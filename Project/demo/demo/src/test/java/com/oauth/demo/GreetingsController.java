package com.oauth.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Spring Security!";
    }

    @GetMapping("/")
    public String home() {
        return "Welcome! Go to /hello after login.";
    }
}
