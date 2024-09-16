package ru.komarreks.students.controller;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.komarreks.students.model.Student;
import ru.komarreks.students.repository.RepositoryInterface;

import java.util.List;

@RestController
@RequestMapping("/student/")
public class StudentController {

    @Autowired
    RepositoryInterface repository;

    @GetMapping(value = "{id}")
    public Student getStudent(@PathVariable int id){
        return repository.read(id);
    }

    @GetMapping
    public List<Student> getAll(){
        return repository.getAll();
    }

    @GetMapping("/search{name}")
    public List<Student> find(@PathParam(value = "name") String name){
        return repository.findByName(name);
    }

    @GetMapping("/group/{groupName}/student")
    public List<Student> findByGroup(@PathVariable String groupName){
        return repository.fyndByGroup(groupName);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public boolean create(@RequestBody JsonNode js){
        String name = null;
        String group = null;
        if (js.get("name")!=null){
            name = js.get("name").textValue();
        }
        if (js.get("group")!=null){
            group = js.get("group").textValue();
        }

        if (name != null && group != null){
            return repository.create(new Student(name, group));
        }

        return false;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){
        return repository.delete(id);
    }
}
