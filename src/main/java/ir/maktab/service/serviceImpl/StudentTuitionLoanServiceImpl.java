package ir.maktab.service.serviceImpl;

import ir.maktab.entitty.StudentTuitionLoan;
import ir.maktab.entitty.enums.Grade;
import ir.maktab.repository.StudentTuitionLoanRepository;
import ir.maktab.service.StudentTuitionLoanService;

public class StudentTuitionLoanServiceImpl implements StudentTuitionLoanService {
    StudentTuitionLoanRepository studentTuitionLoanRepository = new StudentTuitionLoanRepository();

    @Override
    public void saveNewStudentTuitionLoan(StudentTuitionLoan studentTuitionLoan) {
        if (studentTuitionLoan.getGrade().equals(Grade.ASSOCIATE) ||
                studentTuitionLoan.getGrade().equals(Grade.CONTINUOUS_BACHELORS) ||
                studentTuitionLoan.getGrade().equals(Grade.DISCONTINUOUS_BACHELORS)) {
            studentTuitionLoan.setAmount(1300000);
        } else if (studentTuitionLoan.getGrade().equals(Grade.CONTINUOUS_MASTER) ||
                studentTuitionLoan.getGrade().equals(Grade.DISCONTINUOUS_MASTER) ||
                studentTuitionLoan.getGrade().equals(Grade.PHD) || studentTuitionLoan.getGrade().
                equals(Grade.CONTINUOUS_PHD)) {
            studentTuitionLoan.setAmount(2600000);
        } else if (studentTuitionLoan.getGrade().equals(Grade.DISCONTINUOUS_SPECIALIZED_DOCTORATE)) {
            studentTuitionLoan.setAmount(65000000);
        }
        studentTuitionLoanRepository.creat(studentTuitionLoan);
    }

    @Override
    public StudentTuitionLoan findStudentTuitionLoanById(int id) {
        return studentTuitionLoanRepository.findById(id);
    }

    @Override
    public void updateStudentTuitionLoan(StudentTuitionLoan studentTuitionLoan) {
        studentTuitionLoanRepository.update(studentTuitionLoan);
    }

    @Override
    public void deleteStudentTuitionLoan(StudentTuitionLoan studentTuitionLoan) {
        studentTuitionLoanRepository.remove(studentTuitionLoan);
    }
}
