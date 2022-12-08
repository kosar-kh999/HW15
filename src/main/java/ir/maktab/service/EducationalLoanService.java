package ir.maktab.service;

import ir.maktab.entitty.EducationLoan;

public interface EducationalLoanService {
    void saveNewEducationalLoan(EducationLoan educationLoan);

    EducationLoan findEducationalLoanById(int id);

    void updateEducationalLoan(EducationLoan educationLoan);

    void deleteEducationalLoan(EducationLoan educationLoan);
}
