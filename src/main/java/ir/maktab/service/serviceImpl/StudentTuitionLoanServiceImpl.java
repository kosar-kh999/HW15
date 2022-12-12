package ir.maktab.service.serviceImpl;

import ir.maktab.entitty.StudentTuitionLoan;
import ir.maktab.entitty.enums.Grade;
import ir.maktab.entitty.enums.UniversityType;
import ir.maktab.exception.LoanException;
import ir.maktab.repository.StudentTuitionLoanRepository;
import ir.maktab.service.StudentTuitionLoanService;
import ir.maktab.util.DateUtil;

import java.time.LocalDateTime;

public class StudentTuitionLoanServiceImpl implements StudentTuitionLoanService {
    StudentTuitionLoanRepository studentTuitionLoanRepository = new StudentTuitionLoanRepository();

    @Override
    public void saveNewStudentTuitionLoan(StudentTuitionLoan studentTuitionLoan) throws LoanException {
        if (studentTuitionLoan.getUniversityType().equals(UniversityType.AZAD) ||
                studentTuitionLoan.getUniversityType().equals(UniversityType.APPLIED_SCIENCES) ||
                studentTuitionLoan.getUniversityType().equals(UniversityType.COMPOUND) ||
                studentTuitionLoan.getUniversityType().equals(UniversityType.EVENING) ||
                studentTuitionLoan.getUniversityType().equals(UniversityType.EXCESS_CAPACITY) ||
                studentTuitionLoan.getUniversityType().equals(UniversityType.NONPROFIT) ||
                studentTuitionLoan.getUniversityType().equals(UniversityType.PAYAM_NOOR)) {
            if (studentTuitionLoan.getGrade().equals(Grade.ASSOCIATE) ||
                    studentTuitionLoan.getGrade().equals(Grade.CONTINUOUS_BACHELORS) ||
                    studentTuitionLoan.getGrade().equals(Grade.DISCONTINUOUS_BACHELORS)) {
                studentTuitionLoan.setAmount(32000000);
            } else if (studentTuitionLoan.getGrade().equals(Grade.CONTINUOUS_MASTER) ||
                    studentTuitionLoan.getGrade().equals(Grade.DISCONTINUOUS_MASTER) ||
                    studentTuitionLoan.getGrade().equals(Grade.PHD) || studentTuitionLoan.getGrade().
                    equals(Grade.CONTINUOUS_PHD)) {
                studentTuitionLoan.setAmount(26000000);
            } else if (studentTuitionLoan.getGrade().equals(Grade.DISCONTINUOUS_SPECIALIZED_DOCTORATE)) {
                studentTuitionLoan.setAmount(19500000);
            }
            studentTuitionLoanRepository.creat(studentTuitionLoan);
        } else throw new LoanException(" You don't have enough requirements ! ");
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

    @Override
    public void getDate(StudentTuitionLoan studentTuitionLoan) throws LoanException {
        LocalDateTime firstDate = DateUtil.changeDateToLocalDateTime(studentTuitionLoan.getRequestDate());
        LocalDateTime secondDate = DateUtil.changeDateToLocalDateTime(studentTuitionLoan.getRequestDate());
        if (firstDate.getDayOfMonth() > 22 && firstDate.getDayOfMonth() < 30 && firstDate.getMonthValue() == 10) {
            saveNewStudentTuitionLoan(studentTuitionLoan);
        } else {
            if (secondDate.getDayOfMonth() > 13 && secondDate.getDayOfMonth() < 21 && secondDate.getMonthValue() == 2) {
                saveNewStudentTuitionLoan(studentTuitionLoan);
            }
        }
        throw new LoanException("You can't request for loan in this time ! ");
    }

}
