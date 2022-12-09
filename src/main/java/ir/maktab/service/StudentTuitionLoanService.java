package ir.maktab.service;

import ir.maktab.entitty.EducationLoan;
import ir.maktab.entitty.StudentTuitionLoan;

public interface StudentTuitionLoanService {
    void saveNewStudentTuitionLoan(EducationLoan educationLoan);

    StudentTuitionLoan findStudentTuitionLoanById(int id);

    void updateStudentTuitionLoan(StudentTuitionLoan studentTuitionLoan);

    void deleteStudentTuitionLoan(StudentTuitionLoan studentTuitionLoan);
}
