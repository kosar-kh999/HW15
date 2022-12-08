package ir.maktab.entitty;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@IdClass(AllocatedLoanId.class)
public class AllocatedLoan {
    @Id
    @ManyToOne
    Collegian collegian;
    @Id
    @ManyToOne
    Loan loan;
    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    Date receiveLoan;
    @OneToOne(cascade = CascadeType.MERGE)
    CreditCard creditCard;
}
