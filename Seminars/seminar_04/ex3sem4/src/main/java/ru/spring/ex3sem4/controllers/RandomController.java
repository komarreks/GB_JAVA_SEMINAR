package ru.spring.ex3sem4.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class RandomController {

    @Value("${data.parametr.min:0}")
    private int minDefault;

    @Value("${data.parametr.max:1000}")
    private int maxDefault;

    @GetMapping("/random/{min}/{max}")
    public String getRandom(@PathVariable int min,
                            @PathVariable int max,
                            Model md){

        md.addAttribute("min", min);
        md.addAttribute("max", max);
        md.addAttribute("random", new Random().nextInt(min, max+1));

        return "random";
    }

    @GetMapping("/random")
    public String getRandomWithParams(@RequestParam("min") int min,
                            @RequestParam("max") int max,
                            Model md){

        md.addAttribute("min_def", minDefault);
        md.addAttribute("max_def", maxDefault);
        md.addAttribute("min", min);
        md.addAttribute("max", max);
        md.addAttribute("random", new Random().nextInt(min, max+1));

        return "random";
    }
}
