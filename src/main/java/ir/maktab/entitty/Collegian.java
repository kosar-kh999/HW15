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
    @OneToOne(cascade = CascadeType.MERGE)
    Account account;
    @OneToOne(cascade = CascadeType.MERGE)
    UniversityInfo universityInfo;
    @Enumerated(EnumType.STRING)
    MaritalStatus maritalStatus;
    boolean dormitoryResident;
    @OneToMany
    List<CreditCard> creditCards = new ArrayList<>();

    public Collegian(String firstName, String lastName, String fatherName, String motherName,
                     String birthCertificateNumber, String nationalCode, Date birthDate, Account account, UniversityInfo universityInfo) {
        super(firstName, lastName, fatherName, motherName, birthCertificateNumber, nationalCode, birthDate);
        this.account = account;
        this.universityInfo = universityInfo;
    }

    public Collegian() {

    }
}
