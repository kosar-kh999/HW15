package ir.maktab.service;

import ir.maktab.entitty.HousingLoan;
import ir.maktab.exception.LoanException;

public interface HousingLoanService {
    void saveNewHousingLoan(HousingLoan housingLoan) throws LoanException;

    HousingLoan findById(int id);

    void update(HousingLoan housingLoan);

    void remove(HousingLoan housingLoan);

    void getDate(HousingLoan housingLoan) throws LoanException;

}
