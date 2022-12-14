package ir.maktab.entitty;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(unique = true)
    String username;
    String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account() {

    }
}
