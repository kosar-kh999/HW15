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
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String firstName;
    String lastName;
    String fatherName;
    String motherName;
    @Column(nullable = false)
    String BirthCertificateNumber;
    @Column(nullable = false, unique = true)
    String nationalCode;
    @Temporal(TemporalType.DATE)
    Date birthDate;

    public Person(String firstName, String lastName, String fatherName, String motherName,
                  String birthCertificateNumber, String nationalCode, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.motherName = motherName;
        BirthCertificateNumber = birthCertificateNumber;
        this.nationalCode = nationalCode;
        this.birthDate = birthDate;
    }

    public Person() {

    }
}
