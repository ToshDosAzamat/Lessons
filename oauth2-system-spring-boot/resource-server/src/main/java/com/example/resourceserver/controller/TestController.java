package com.example.resourceserver.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TestController{
    @GetMapping("/hello")
    public String whoami() {
        var jwt = (Jwt) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return "ClientID: "+jwt.getSubject()+" -----> This is resource-server!";
    }

}
