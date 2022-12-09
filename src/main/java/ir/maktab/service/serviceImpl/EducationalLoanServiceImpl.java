package ir.maktab.service.serviceImpl;

import ir.maktab.entitty.EducationLoan;
import ir.maktab.entitty.enums.Grade;
import ir.maktab.repository.EducationalLoanRepository;
import ir.maktab.service.EducationalLoanService;

public class EducationalLoanServiceImpl implements EducationalLoanService {
    EducationalLoanRepository educationalLoanRepository = new EducationalLoanRepository();
    EducationLoan educationLoan = new EducationLoan();

    @Override
    public void saveNewEducationalLoan(EducationLoan educationLoan) {
        if (educationLoan.getGrade().equals(Grade.ASSOCIATE) ||
                educationLoan.getGrade().equals(Grade.CONTINUOUS_BACHELORS) ||
                educationLoan.getGrade().equals(Grade.DISCONTINUOUS_BACHELORS)) {
            educationLoan.setAmount(1900000);
        } else if (educationLoan.getGrade().equals(Grade.CONTINUOUS_MASTER) ||
                educationLoan.getGrade().equals(Grade.DISCONTINUOUS_MASTER) ||
                educationLoan.getGrade().equals(Grade.PHD) || educationLoan.getGrade().equals(Grade.CONTINUOUS_PHD)) {
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
}
