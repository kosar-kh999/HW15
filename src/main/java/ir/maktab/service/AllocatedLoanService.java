package ir.maktab.service;

import ir.maktab.entitty.AllocatedLoan;
import ir.maktab.entitty.Collegian;
import ir.maktab.entitty.CreditCard;
import ir.maktab.entitty.Loan;
import ir.maktab.exception.LoanException;

public interface AllocatedLoanService {
    void saveNewAllocatedLoan(Loan loan, Collegian collegian);

    void setCreditCard(CreditCard creditCard, AllocatedLoan allocatedLoan) throws LoanException;

    AllocatedLoan find(Loan loan, Collegian collegian);

    void removeAllocatedLoan(Loan loan, Collegian collegian);
}
