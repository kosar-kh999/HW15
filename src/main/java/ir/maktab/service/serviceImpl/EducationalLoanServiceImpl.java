package ir.maktab.service.serviceImpl;

import ir.maktab.entitty.EducationLoan;
import ir.maktab.entitty.enums.Grade;
import ir.maktab.exception.LoanException;
import ir.maktab.repository.EducationalLoanRepository;
import ir.maktab.service.EducationalLoanService;
import ir.maktab.util.DateUtil;

import java.time.LocalDateTime;

public class EducationalLoanServiceImpl implements EducationalLoanService {
    EducationalLoanRepository educationalLoanRepository = new EducationalLoanRepository();

    @Override
    public void saveNewEducationalLoan(EducationLoan educationLoan) {
        if (educationLoan.getGrade().equals(Grade.ASSOCIATE) ||
                educationLoan.getGrade().equals(Grade.CONTINUOUS_BACHELORS) ||
                educationLoan.getGrade().equals(Grade.DISCONTINUOUS_BACHELORS)) {
            educationLoan.setAmount(1900000);
        } else if (educationLoan.getGrade().equals(Grade.CONTINUOUS_MASTER) ||
                educationLoan.getGrade().equals(Grade.DISCONTINUOUS_MASTER) ||
                educationLoan.getGrade().equals(Grade.PHD) || educationLoan.getGrade().
                equals(Grade.CONTINUOUS_PHD)) {
            educationLoan.setAmount(2250000);
        } else if (educationLoan.getGrade().equals(Grade.DISCONTINUOUS_SPECIALIZED_DOCTORATE)) {
            educationLoan.setAmount(2600000);
        }
        educationalLoanRepository.creat(educationLoan);
    }

    @Override
    public EducationLoan findEducationalLoanById(int id) {
        return educationalLoanRepository.findById(id);
    }

    @Override
    public void updateEducationalLoan(EducationLoan educationLoan) {
        educationalLoanRepository.update(educationLoan);
    }

    @Override
    public void deleteEducationalLoan(EducationLoan educationLoan) {
        educationalLoanRepository.remove(educationLoan);
    }

    @Override
    public void getDate(EducationLoan educationLoan) throws LoanException {
        LocalDateTime firstDate = DateUtil.changeDateToLocalDateTime(educationLoan.getRequestDate());
        LocalDateTime secondDate = DateUtil.changeDateToLocalDateTime(educationLoan.getRequestDate());
        if (firstDate.getDayOfMonth() > 22 && firstDate.getDayOfMonth() < 30 && firstDate.getMonthValue() == 10) {
            saveNewEducationalLoan(educationLoan);
        } else {
            if (secondDate.getDayOfMonth() > 13 && secondDate.getDayOfMonth() < 21 && secondDate.getMonthValue() == 2) {
                saveNewEducationalLoan(educationLoan);
            }
        }
        throw new LoanException("You can't request for loan in this time ! ");
    }
}
