package ru.gb.springdemo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Setter
@Getter
@Entity
@Table(name = "users")
public class CustomUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private String id;

    private String login;
    private String password;

    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<UserRole> roles = new ArrayList<>();

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id='").append(id).append('\'');
        sb.append(", login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", reader=").append(reader);
//        sb.append(", roles=").append(roles);
        sb.append('}');
        return sb.toString();
    }
}
