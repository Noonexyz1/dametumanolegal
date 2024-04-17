package com.dametumanolegal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {

    @GetMapping("/test")
    public String functionToTestResponse(){
        return "Hola Proyecto";
    }

}
