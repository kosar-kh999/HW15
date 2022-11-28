package ir.maktab.entitty;

import ir.maktab.entitty.enums.Grade;
import ir.maktab.entitty.enums.UniversityType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Collegian {
    @Column(nullable = false, unique = true)
    String studentNumber;
    String universityName;
    @Enumerated(EnumType.STRING)
    UniversityType universityType;
    @Temporal(TemporalType.DATE)
    Date enteringDate;
    @Enumerated(EnumType.STRING)
    Grade grade;
}
