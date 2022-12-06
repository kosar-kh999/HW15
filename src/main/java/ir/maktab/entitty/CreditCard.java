package ir.maktab.entitty;

import ir.maktab.entitty.enums.BankType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(unique = true, length = 16)
    String cartNumber;
    @Temporal(TemporalType.TIMESTAMP)
    Date expirationDate;
    @Column(length = 4)
    Integer cvv2;
    @Temporal(TemporalType.DATE)
    Date OpeningDate;
    @Enumerated(EnumType.STRING)
    BankType bankType;
}
