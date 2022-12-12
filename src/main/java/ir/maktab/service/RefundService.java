package ir.maktab.service;

import ir.maktab.entitty.AllocatedLoan;
import ir.maktab.entitty.Refund;
import ir.maktab.exception.RefundException;

import java.util.List;

public interface RefundService {
    void saveNewRefund(Refund refund);

    Refund findById(int id);

    void update(Refund refund);

    void delete(Refund refund);

    void increaseMonthOfPaid(Refund refund);

    void decreaseMonthOfRemain(Refund refund);

    List<Refund> getAll(Refund refund);

    double repaymentAmount(double amount, int years, double interestRate);

    void startOfRefund(AllocatedLoan allocatedLoan, Refund refund) throws RefundException;
}
