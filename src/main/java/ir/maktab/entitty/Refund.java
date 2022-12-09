package ir.maktab.entitty;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@ToString
@Setter
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Refund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    double refundAmount;
    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    Date dateOfPayment;
    boolean isPaid;
    final int NUMBER_OF_MONTH = 60;
}
