package ru.gb.springdemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.springdemo.model.Roles;
import ru.gb.springdemo.model.CustomUser;
import ru.gb.springdemo.model.UserRole;
import ru.gb.springdemo.repository.UsersRolesRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RolesService {

    private final UsersRolesRepository repository;

    public UserRole save(UserRole userRole){
        repository.save(userRole);
        return userRole;
    }

    public List<String> rolesOfUser(CustomUser user){
        return repository.findByUser(user.getId());
    }

    public void createRoles(List<CustomUser> readers, List<CustomUser> admins){

        List<UserRole> rolesForCreate = new ArrayList<>();

        for (CustomUser reader: readers) {
            UserRole userRole = new UserRole(reader, Roles.READER.getName());
            rolesForCreate.add(userRole);
        }

        for (CustomUser admin: admins) {
            UserRole userRole = new UserRole(admin, Roles.ADMIN.getName());
            rolesForCreate.add(userRole);
        }

        repository.saveAll(rolesForCreate);
    }
}
