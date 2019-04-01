package com.example.ribbonconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Test {
    @Autowired
    RestTemplate restTemplate;
    public String Test(){

        return restTemplate.getForObject("http://ribbon-provider/hello?name=123",String.class);
    }
}
