package ir.maktab.service.serviceImpl;

import ir.maktab.entitty.EducationLoan;
import ir.maktab.repository.EducationalLoanRepository;
import ir.maktab.service.EducationalLoanService;

public class EducationalLoanServiceImpl implements EducationalLoanService {
    EducationalLoanRepository educationalLoanRepository = new EducationalLoanRepository();

    @Override
    public void saveNewEducationalLoan(EducationLoan educationLoan) {
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
