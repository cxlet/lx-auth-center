package com.example.lxauthcenter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello, secure world!";
    }

    @GetMapping("/api/public")
    public String publicEndpoint() {
        return "Hello, public world!";
    }
}
