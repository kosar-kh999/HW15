package ir.maktab.service.serviceImpl;

import ir.maktab.entitty.AllocatedLoan;
import ir.maktab.entitty.Collegian;
import ir.maktab.entitty.CreditCard;
import ir.maktab.entitty.Loan;
import ir.maktab.entitty.enums.BankType;
import ir.maktab.exception.LoanException;
import ir.maktab.repository.AllocatedLoanRepository;
import ir.maktab.service.AllocatedLoanService;

import java.util.Date;

public class AllocatedLoanServiceImpl implements AllocatedLoanService {
    AllocatedLoanRepository allocatedLoanRepository = new AllocatedLoanRepository();

    @Override
    public void saveNewAllocatedLoan(Loan loan, Collegian collegian) {
        AllocatedLoan allocatedLoan = new AllocatedLoan();
        allocatedLoan.setLoan(loan);
        allocatedLoan.setCollegian(collegian);
        //allocatedLoan.setRequestDate(new Date());
        allocatedLoanRepository.persist(allocatedLoan);
    }

    @Override
    public void setCreditCard(CreditCard creditCard, AllocatedLoan allocatedLoan) throws LoanException {
        if (creditCard.getBankType().equals(BankType.MASKAN) || creditCard.getBankType().equals(BankType.MELI)
                || creditCard.getBankType().equals(BankType.REFAH) ||
                creditCard.getBankType().equals(BankType.TEJARAT)) {
            allocatedLoan.setCreditCard(creditCard);
            allocatedLoanRepository.update(allocatedLoan);
        } else if (creditCard.getBankType().equals(BankType.OTHER_BANK)) {
            throw new LoanException("You don't have enough requirements !");
        }
    }


    @Override
    public AllocatedLoan find(Loan loan, Collegian collegian) {
        return allocatedLoanRepository.find(loan, collegian);
    }

    @Override
    public void removeAllocatedLoan(Loan loan, Collegian collegian) {
        allocatedLoanRepository.remove(loan, collegian);
    }
}
