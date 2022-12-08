package ir.maktab.service;

import ir.maktab.entitty.HousingLoan;

public interface HousingLoanService {
    void saveNewHousingLoan(HousingLoan housingLoan);

    HousingLoan findById(int id);

    void update(HousingLoan housingLoan);

    void remove(HousingLoan housingLoan);
}
