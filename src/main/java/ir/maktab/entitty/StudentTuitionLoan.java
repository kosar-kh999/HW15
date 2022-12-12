package ir.maktab.entitty;

import ir.maktab.entitty.enums.Grade;
import ir.maktab.entitty.enums.PaymentPeriod;
import ir.maktab.entitty.enums.UniversityType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class StudentTuitionLoan extends Loan {
    @Enumerated(EnumType.STRING)
    Grade grade;

    public StudentTuitionLoan(PaymentPeriod paymentPeriod, Date requestDate, UniversityType universityType, Grade grade) {
        super(paymentPeriod, requestDate, universityType);
        this.grade = grade;
    }
}
