package ir.maktab.entitty;

import ir.maktab.entitty.enums.Grade;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class StudentTuitionLoan extends Loan {
    @Enumerated(EnumType.STRING)
    Grade grade;
}
