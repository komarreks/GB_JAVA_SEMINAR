package ru.gb.springdemo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Data
@Entity
@Table(name = "user_roles")
@NoArgsConstructor
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private CustomUser user;

    private String role;

    public UserRole(CustomUser user, String role){
        this.user = user;
        this.role = role;
    }
}
