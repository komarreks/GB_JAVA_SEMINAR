package ru.gb.springdemo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.gb.springdemo.model.CustomUser;
import ru.gb.springdemo.model.UserRole;
import ru.gb.springdemo.service.RolesService;
import ru.gb.springdemo.service.UserService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserService service;
    private final RolesService rolesService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        CustomUser foundedUser = service.findByName(username);

        if (foundedUser == null){
            throw new UsernameNotFoundException("User not found");
        }

        List<String> roles = rolesService.rolesOfUser(foundedUser);

        return new User(foundedUser.getLogin(), foundedUser.getPassword(), roles.stream().map(SimpleGrantedAuthority::new).toList());

    }
}
