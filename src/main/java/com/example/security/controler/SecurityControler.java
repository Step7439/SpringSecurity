package com.example.security.controler;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class SecurityControler {

    @GetMapping("/hello")
    public String hello(){
        return "Heloo";
    }
    @PreAuthorize("hasAnyRole('WRITE')")
    @GetMapping("/avto")
    public String login(){
        return "Hello user !!!";
    }
    @RolesAllowed({"ROLE_READ"})
    @GetMapping("/read")
    public String read(){
        return "read";
    }
    @Secured({"ROLE_WRITE"})
    @GetMapping("/write")
    public String write(){
        return "write";
    }
    @GetMapping("/hi")
    public String hi(){
        return "hi";
    }
    @PostMapping("/hi")
    public String hiPost(){
        return "hiPost";
    }

    @PostAuthorize("#username == authentication.principal.username")
    public String loginEquls(String username) {
        return "Hello Username - " + username;
    }

}
