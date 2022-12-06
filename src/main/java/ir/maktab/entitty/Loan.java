package ir.maktab.entitty;

import ir.maktab.entitty.enums.PaymentPeriod;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@Inheritance(strategy = InheritanceType.JOINED)
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    double amount;
    @Enumerated(EnumType.STRING)
    PaymentPeriod paymentPeriod;
}
