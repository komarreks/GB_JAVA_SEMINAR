package ru.gb.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.springdemo.model.CustomUser;

@Repository
public interface UserRepository extends JpaRepository<CustomUser, String> {

    CustomUser findByLogin(String name);

}
