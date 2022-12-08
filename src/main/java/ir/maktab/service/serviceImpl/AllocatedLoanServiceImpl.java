package ir.maktab.service.serviceImpl;

import ir.maktab.entitty.AllocatedLoan;
import ir.maktab.entitty.Collegian;
import ir.maktab.entitty.Loan;
import ir.maktab.repository.AllocatedLoanRepository;
import ir.maktab.service.AllocatedLoanService;

public class AllocatedLoanServiceImpl implements AllocatedLoanService {
    AllocatedLoanRepository allocatedLoanRepository = new AllocatedLoanRepository();

    @Override
    public void saveNewAllocatedLoan(AllocatedLoan allocatedLoan) {
        allocatedLoanRepository.persist(allocatedLoan);
    }

    @Override
    public void updateAllocatedLoan(AllocatedLoan allocatedLoan) {
        allocatedLoanRepository.update(allocatedLoan);
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
