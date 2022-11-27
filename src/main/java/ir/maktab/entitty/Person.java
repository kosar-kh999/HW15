package ir.maktab.entitty;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String firstName;
    String lastName;
    String fatherName;
    String motherName;
    @Column(length = 10, nullable = false)
    String BirthCertificateNumber;
    @Column(length = 10, nullable = false, unique = true)
    String nationalCode;
    @Temporal(TemporalType.DATE)
    Date birthDate;
}
