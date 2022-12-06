package ir.maktab.entitty.enums;

public enum BigCityName {
    GILAN, ESFAHAN, AZARBAIJAN_SHARGHI,
    FARS, KHOZESTAN, QOM, KHORASAN_RAZAVI, ALBORZ;

    public CityType toCityType(){
        switch (this){
            case GILAN, ESFAHAN, AZARBAIJAN_SHARGHI,
                    FARS, KHOZESTAN, QOM, KHORASAN_RAZAVI, ALBORZ:
            return CityType.BIG_CITY;
            default:
                return null;
        }
    }
}
