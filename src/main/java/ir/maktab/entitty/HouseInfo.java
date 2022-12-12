package ir.maktab.entitty;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embeddable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@Embeddable
@NoArgsConstructor
public class HouseInfo {
    Long housingRentalContractNumber;
    String address;

    public HouseInfo(Long housingRentalContractNumber, String address) {
        this.housingRentalContractNumber = housingRentalContractNumber;
        this.address = address;
    }
}
