package ir.maktab.entitty;

import ir.maktab.entitty.enums.CityType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class HousingLoan extends Loan {
    @Enumerated(EnumType.STRING)
    CityType cityType;
    @Embedded
    HouseInfo houseInfo;
}
