package ru.gb.springdemo.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import ru.gb.springdemo.model.CustomUser;

import ru.gb.springdemo.repository.UserRepository;


import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final RolesService rolesService;

    @PostConstruct
    public void firstInit(){
        if (repository.findAll().size() == 0){
            CustomUser admin = new CustomUser();
            admin.setLogin("Admin");
            admin.setPassword("$2y$10$Kn4fAzlz/n63K67ihOd0zepTEQ3fjLO9C8fpPuf89WLKV7LIdFhLO");

            CustomUser reader = new CustomUser();
            reader.setLogin("Reader");
            reader.setPassword("$2y$10$kAOs8Rd935cIL4wkKPYIjO7QUGPaTLf5MpBcNgLbXm4Xro.326liO");

            repository.saveAll(List.of(admin, reader));

            rolesService.createRoles(List.of(admin, reader), List.of(admin));
        }
    }

    public CustomUser findByName(String name){
        return repository.findByLogin(name);
    }
}
