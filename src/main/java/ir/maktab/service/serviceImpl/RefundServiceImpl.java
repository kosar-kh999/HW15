package ir.maktab.service.serviceImpl;

import ir.maktab.entitty.Refund;
import ir.maktab.repository.RefundRepository;
import ir.maktab.service.RefundService;

import java.util.List;

public class RefundServiceImpl implements RefundService {
    RefundRepository refundRepository = new RefundRepository();

    @Override
    public void saveNewRefund(Refund refund) {
        if (refund.getNumberOfMonth() > 0 || refund.getNumberOfMonth() < 13){

        }
        refundRepository.creat(refund);
    }

    @Override
    public Refund findById(int id) {
        return refundRepository.findById(id);
    }

    @Override
    public void update(Refund refund) {
        refundRepository.update(refund);
    }

    @Override
    public void delete(Refund refund) {
        refundRepository.remove(refund);
    }

    @Override
    public void increaseMonthOfPaid(Refund refund) {
        refundRepository.increaseMonthOfPaid(refund);
    }

    @Override
    public void decreaseMonthOfRemain(Refund refund) {
        refundRepository.decreaseMonthOfRemain(refund);
    }

    @Override
    public List<Refund> getAll() {
        return refundRepository.getAll();
    }

    /*public double calculateRefund(Refund refund){

    }*/
}
