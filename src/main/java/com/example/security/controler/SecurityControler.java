package com.example.security.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityControler {

    @GetMapping("/hello")
    public String hello(){
        return "Heloo";
    }
    @GetMapping("/login")
    public String login(){
        return "Hello user !!!";
    }
    @GetMapping("/read")
    public String read(){
        return "read";
    }
    @GetMapping("/write")
    public String write(){
        return "write";
    }
}
