package ir.maktab.entitty;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AllocatedLoanId implements Serializable {
    Loan loan;
    Collegian collegian;
}
