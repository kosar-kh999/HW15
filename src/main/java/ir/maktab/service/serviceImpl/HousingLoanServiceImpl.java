package ir.maktab.service.serviceImpl;

import ir.maktab.entitty.Collegian;
import ir.maktab.entitty.HousingLoan;
import ir.maktab.entitty.enums.CityType;
import ir.maktab.entitty.enums.MaritalStatus;
import ir.maktab.exception.LoanException;
import ir.maktab.repository.HousingLoanRepository;
import ir.maktab.service.HousingLoanService;
import ir.maktab.util.DateUtil;

import java.time.LocalDateTime;

public class HousingLoanServiceImpl implements HousingLoanService {
    HousingLoanRepository housingLoanRepository = new HousingLoanRepository();
    Collegian collegian = new Collegian();

    @Override
    public void saveNewHousingLoan(HousingLoan housingLoan) throws LoanException {
        if (!collegian.isDormitoryResident() && collegian.getMaritalStatus().equals(MaritalStatus.MARRIED)) {
            if (housingLoan.getCityType().equals(CityType.TEHRAN)) {
                housingLoan.setAmount(32000000);
            } else if (housingLoan.getCityType().equals(CityType.BIG_CITY)) {
                housingLoan.setAmount(26000000);
            } else if (housingLoan.getCityType().equals(CityType.OTHER_CITY)) {
                housingLoan.setAmount(19500000);
            }
            housingLoanRepository.creat(housingLoan);
        }
        throw new LoanException(" You don't have enough requirements ! ");
    }

    @Override
    public HousingLoan findById(int id) {
        return housingLoanRepository.findById(id);
    }

    @Override
    public void update(HousingLoan housingLoan) {
        housingLoanRepository.update(housingLoan);
    }

    @Override
    public void remove(HousingLoan housingLoan) {
        housingLoanRepository.remove(housingLoan);
    }

    @Override
    public void getDate(HousingLoan housingLoan) throws LoanException {
        LocalDateTime firstDate = DateUtil.changeDateToLocalDateTime(housingLoan.getRequestDate());
        LocalDateTime secondDate = DateUtil.changeDateToLocalDateTime(housingLoan.getRequestDate());
        if (firstDate.getDayOfMonth() > 22 && firstDate.getDayOfMonth() < 30 && firstDate.getMonthValue() == 10) {
            saveNewHousingLoan(housingLoan);
        } else {
            if (secondDate.getDayOfMonth() > 13 && secondDate.getDayOfMonth() < 21 && secondDate.getMonthValue() == 2) {
                saveNewHousingLoan(housingLoan);
            }
        }
        throw new LoanException("You can't request for loan in this time ! ");
    }
}
