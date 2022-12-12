package ir.maktab.entitty;

import ir.maktab.entitty.enums.Grade;
import ir.maktab.entitty.enums.PaymentPeriod;
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
public class EducationLoan extends Loan {
    @Enumerated(EnumType.STRING)
    Grade grade;

    public EducationLoan(PaymentPeriod paymentPeriod, Date requestDate, Grade grade) {
        super(paymentPeriod, requestDate);
        this.grade = grade;
    }
}
