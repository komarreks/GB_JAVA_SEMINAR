package ru.spring.ex2sem4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class RandomController {

    @GetMapping("/random")
    public String getRandom(Model md){
        int random = new Random().nextInt(0,101);

        md.addAttribute("random", random);

        return "random";
    }
}
