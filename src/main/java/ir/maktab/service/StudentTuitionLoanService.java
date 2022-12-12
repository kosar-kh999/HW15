package ir.maktab.service;

import ir.maktab.entitty.StudentTuitionLoan;
import ir.maktab.exception.LoanException;

public interface StudentTuitionLoanService {
    void saveNewStudentTuitionLoan(StudentTuitionLoan studentTuitionLoan) throws LoanException;

    StudentTuitionLoan findStudentTuitionLoanById(int id);

    void updateStudentTuitionLoan(StudentTuitionLoan studentTuitionLoan);

    void deleteStudentTuitionLoan(StudentTuitionLoan studentTuitionLoan);

    void getDate(StudentTuitionLoan studentTuitionLoan) throws LoanException;

}
