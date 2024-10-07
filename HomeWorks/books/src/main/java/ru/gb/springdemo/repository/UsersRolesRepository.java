package ru.gb.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.gb.springdemo.model.CustomUser;
import ru.gb.springdemo.model.UserRole;

import java.util.List;

@Repository
public interface UsersRolesRepository extends JpaRepository<UserRole, String> {

    @Query(nativeQuery = true, value = "SELECT role FROM user_roles WHERE user_id = :user_id")
    List<String> findByUser(String user_id);

}
