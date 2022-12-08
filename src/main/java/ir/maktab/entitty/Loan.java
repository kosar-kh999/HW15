package ir.maktab.entitty;

import ir.maktab.entitty.enums.PaymentPeriod;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@Inheritance(strategy = InheritanceType.JOINED)
public class Loan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    double amount;
    @Enumerated(EnumType.STRING)
    PaymentPeriod paymentPeriod;
}
