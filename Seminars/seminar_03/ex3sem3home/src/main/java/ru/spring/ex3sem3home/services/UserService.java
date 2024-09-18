package ru.spring.ex3sem3home.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spring.ex3sem3home.model.User;

@Service
public class UserService {

    @Autowired
    private NotificationService notificationService;

    public User createUser(String name, int age, String email){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        notificationService.notifyUser(user);

        return user;
    }

}
