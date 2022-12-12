package ir.maktab.entitty;

import ir.maktab.entitty.enums.CityType;
import ir.maktab.entitty.enums.PaymentPeriod;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embedded;
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
public class HousingLoan extends Loan {
    @Enumerated(EnumType.STRING)
    CityType cityType;
    @Embedded
    HouseInfo houseInfo;

    public HousingLoan(PaymentPeriod paymentPeriod, Date requestDate, CityType cityType, HouseInfo houseInfo) {
        super(paymentPeriod, requestDate);
        this.cityType = cityType;
        this.houseInfo = houseInfo;
    }
}
