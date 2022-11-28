package ir.maktab.entitty;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embeddable;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Embeddable
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {
    String username;
    String password;
}
