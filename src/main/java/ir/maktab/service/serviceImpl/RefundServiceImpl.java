package ir.maktab.service.serviceImpl;

import ir.maktab.entitty.AllocatedLoan;
import ir.maktab.entitty.Refund;
import ir.maktab.entitty.enums.Grade;
import ir.maktab.exception.RefundException;
import ir.maktab.repository.RefundRepository;
import ir.maktab.service.RefundService;
import ir.maktab.util.DateUtil;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class RefundServiceImpl implements RefundService {
    final int MONTHS_OF_YEAR = 12;
    RefundRepository refundRepository = new RefundRepository();

    @Override
    public void saveNewRefund(Refund refund) {
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
    public List<Refund> getAll(Refund refund) {
        return refundRepository.getAll();
    }

    @Override
    public double repaymentAmount(double amount, int years, double interestRate) {
        double total = amount + amount * interestRate;
        return total / (MONTHS_OF_YEAR * years);
    }

    @Override
    public void startOfRefund(AllocatedLoan allocatedLoan, Refund refund) throws RefundException {
        Date enteringDate = allocatedLoan.getCollegian().getUniversityInfo().getEnteringDate();
        LocalDateTime localDateTime = DateUtil.changeDateToLocalDateTime(enteringDate);
        long difference = DateUtil.findDifference(localDateTime);
        if (allocatedLoan.getCollegian().getUniversityInfo().getGrade().equals(Grade.CONTINUOUS_BACHELORS)) {
            if (difference > 4) {
                refundRepository.creat(refund);
            }
        } else if (allocatedLoan.getCollegian().getUniversityInfo().getGrade().equals(Grade.ASSOCIATE) &&
                (allocatedLoan.getCollegian().getUniversityInfo().getGrade().equals(Grade.DISCONTINUOUS_MASTER))) {
            if (difference > 2) {
                refundRepository.creat(refund);
            }
        } else if (allocatedLoan.getCollegian().getUniversityInfo().getGrade().equals(Grade.CONTINUOUS_MASTER)) {
            if (difference > 6) {
                refundRepository.creat(refund);
            }
        } else if (allocatedLoan.getCollegian().getUniversityInfo().getGrade().
                equals(Grade.DISCONTINUOUS_SPECIALIZED_DOCTORATE) && (allocatedLoan.getCollegian().getUniversityInfo().
                getGrade().equals(Grade.PHD)) && (allocatedLoan.getCollegian().getUniversityInfo().getGrade().
                equals(Grade.CONTINUOUS_PHD))) {
            if (difference > 5) {
                refundRepository.creat(refund);
            }

        } else throw new RefundException("You are not graduated !");
    }
}