package ir.maktab.entitty;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@PrimaryKeyJoinColumn(name = "collegianId")
public class Collegian extends Person {
    @OneToOne
    Account account;
    @OneToOne
    UniversityInfo universityInfo;
}
