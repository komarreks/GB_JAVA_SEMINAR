package ru.spring.ex2sem3.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/hallo")
    public String hallo(){
        return "Hallo";
    }

    @GetMapping("/ciao")
    public String ciao(){
        return "Ciao";
    }
}
