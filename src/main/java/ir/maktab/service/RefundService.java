package ir.maktab.service;

import ir.maktab.entitty.Refund;

import java.util.List;

public interface RefundService {
    void saveNewRefund(Refund refund);

    Refund findById(int id);

    void update(Refund refund);

    void delete(Refund refund);

    void increaseMonthOfPaid(Refund refund);

    void decreaseMonthOfRemain(Refund refund);

    List<Refund> getAll(Refund refund);
}
