package ru.spring.ex3sem3home.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.spring.ex3sem3home.model.User;
import ru.spring.ex3sem3home.services.DataProcessingService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private DataProcessingService dataProcessingService;

    @GetMapping
    public List<String> getAllTasks(){
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");

        return getAllTasks();
    }

    @GetMapping("/sort")
    public List<User> sort(){
        return dataProcessingService.sortUserByAge(dataProcessingService.getUserRepository().getUsers());
    }
}
