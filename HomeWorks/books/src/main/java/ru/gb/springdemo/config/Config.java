package ru.gb.springdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.core.GrantedAuthorityDefaults;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
import ru.gb.springdemo.model.Roles;

//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity(securedEnabled = true)
public class Config {

//    @Bean
//    GrantedAuthorityDefaults grantedAuthorityDefaults(){
//        return new GrantedAuthorityDefaults("");
//    }
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity.authorizeHttpRequests(requests -> requests
//                        .requestMatchers("api/**").anonymous()
//                        .requestMatchers("ui/issues").hasRole(Roles.ADMIN.getName())
//                        .requestMatchers("ui/readers").hasRole(Roles.READER.getName())
//                        .requestMatchers("ui/books").authenticated())
//                .formLogin(Customizer.withDefaults()).
//                build();
//    }
//
//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }


}
