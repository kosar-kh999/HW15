package ir.maktab.service;

import ir.maktab.entitty.EducationLoan;
import ir.maktab.exception.LoanException;

public interface EducationalLoanService {
    void saveNewEducationalLoan(EducationLoan educationLoan) throws LoanException;

    EducationLoan findEducationalLoanById(int id);

    void updateEducationalLoan(EducationLoan educationLoan);

    void deleteEducationalLoan(EducationLoan educationLoan);

    void getDate(EducationLoan educationLoan) throws LoanException;

}
