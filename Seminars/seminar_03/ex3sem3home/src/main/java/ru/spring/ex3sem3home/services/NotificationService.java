package ru.spring.ex3sem3home.services;

import org.springframework.stereotype.Service;
import ru.spring.ex3sem3home.model.User;

@Service
public class NotificationService {

    public void notifyUser(User user){
        System.out.println("A new user has benn created: "+ user.getName());
    }

}
