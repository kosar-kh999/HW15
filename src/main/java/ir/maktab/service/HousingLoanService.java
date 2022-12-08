package ir.maktab.service;

import ir.maktab.entitty.HousingLoan;
import ir.maktab.exception.HousingLoanException;

public interface HousingLoanService {
    void saveNewHousingLoan(HousingLoan housingLoan) throws HousingLoanException;

    HousingLoan findById(int id);

    void update(HousingLoan housingLoan);

    void remove(HousingLoan housingLoan);
}
