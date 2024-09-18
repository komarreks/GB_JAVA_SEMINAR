package ru.spring.ex3sem3home.services;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spring.ex3sem3home.model.User;
import ru.spring.ex3sem3home.repository.UserRepository;

import java.util.Comparator;
import java.util.List;

@Getter
@Setter
@Service
public class DataProcessingService{

    @Autowired
    private UserRepository userRepository;

    public List<User> sortUserByAge(List<User> users){
        return users.stream().sorted(Comparator.comparing(User::getAge)).toList();
    }

    public List<User> filterUserByAge(List<User> users, int age){
        return users.stream().filter(u -> u.getAge() > age).toList();
    }

    public double calculateAverageAge(List<User> users){
        return users.stream().mapToInt(User::getAge).average().orElse(0);
    }

}
