package io.amigos.springSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/greetings")
public class Greetings {
    @GetMapping
    public String hello(){
        return "hey welcome to our API";
    }

}
