package ru.spring.ex3sem3home.repository;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import ru.spring.ex3sem3home.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Setter
public class UserRepository {

    private List<User> users = new ArrayList<>();

}
