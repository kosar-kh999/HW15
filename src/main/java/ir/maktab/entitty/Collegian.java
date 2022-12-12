package ir.maktab.entitty;

import ir.maktab.entitty.enums.MaritalStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Collegian extends Person implements Serializable {
    @Column(unique = true)
    String username;
    String password;
    @OneToOne(cascade = CascadeType.MERGE)
    UniversityInfo universityInfo;
    @Enumerated(EnumType.STRING)
    MaritalStatus maritalStatus;
    boolean isDormitoryResident;
    @OneToMany
    List<CreditCard> creditCards = new ArrayList<>();

    public Collegian(String firstName, String lastName, String fatherName, String motherName,
                     String birthCertificateNumber, String nationalCode, Date birthDate, String username,
                     String password, UniversityInfo universityInfo, MaritalStatus maritalStatus,
                     boolean isDormitoryResident) {
        super(firstName, lastName, fatherName, motherName, birthCertificateNumber, nationalCode, birthDate);
        this.username = username;
        this.password = password;
        this.universityInfo = universityInfo;
        this.maritalStatus = maritalStatus;
        this.isDormitoryResident = isDormitoryResident;
    }

    public Collegian() {

    }

    public Collegian(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
