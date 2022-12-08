package ir.maktab.entitty;

import ir.maktab.entitty.enums.PaymentPeriod;
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
public class Loan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    double amount;
    @Enumerated(EnumType.STRING)
    PaymentPeriod paymentPeriod;
    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    Date receiveDate;
}
