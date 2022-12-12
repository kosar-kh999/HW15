package ir.maktab.entitty;

import ir.maktab.entitty.enums.PaymentPeriod;
import ir.maktab.entitty.enums.UniversityType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor
@AllArgsConstructor
public class Loan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    double amount;
    @Enumerated(EnumType.STRING)
    PaymentPeriod paymentPeriod;
    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    Date requestDate;
    @Enumerated(EnumType.STRING)
    UniversityType universityType;

    public Loan(PaymentPeriod paymentPeriod, Date requestDate, UniversityType universityType) {
        this.paymentPeriod = paymentPeriod;
        this.requestDate = requestDate;
        this.universityType = universityType;
    }

    public Loan(PaymentPeriod paymentPeriod, Date requestDate) {
        this.paymentPeriod = paymentPeriod;
        this.requestDate = requestDate;
    }
}
