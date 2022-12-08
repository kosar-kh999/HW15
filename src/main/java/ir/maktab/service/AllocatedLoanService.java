package ir.maktab.service;

import ir.maktab.entitty.AllocatedLoan;
import ir.maktab.entitty.Collegian;
import ir.maktab.entitty.Loan;

public interface AllocatedLoanService {
    void saveNewAllocatedLoan(AllocatedLoan allocatedLoan);

    void updateAllocatedLoan(AllocatedLoan allocatedLoan);

    AllocatedLoan find(Loan loan, Collegian collegian);

    void removeAllocatedLoan(Loan loan, Collegian collegian);
}
