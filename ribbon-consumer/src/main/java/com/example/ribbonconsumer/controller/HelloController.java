package com.example.ribbonconsumer.controller;


import com.example.ribbonconsumer.service.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private Test helloService;
    @GetMapping("/hello")
    public String sayHello(String name){
        return helloService.Test() + " " + name;
    }
}
