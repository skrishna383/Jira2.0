package com.skrishna383.jira2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcome {
    @GetMapping("/")
    public String home(){
        return ("<h1>welcome<h1>");
    }

    @GetMapping("/user")
    public String userhome(){
        return ("<h1>welcome User<h1>");
    }

    @GetMapping("/admin")
    public String adminhome(){
        return ("<h1>welcome Admin<h1>");
    }
}
