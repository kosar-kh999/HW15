package ir.maktab.service.serviceImpl;

import ir.maktab.entitty.Collegian;
import ir.maktab.entitty.HousingLoan;
import ir.maktab.entitty.enums.CityType;
import ir.maktab.entitty.enums.MaritalStatus;
import ir.maktab.exception.HousingLoanException;
import ir.maktab.repository.HousingLoanRepository;
import ir.maktab.service.HousingLoanService;

public class HousingLoanServiceImpl implements HousingLoanService {
    HousingLoanRepository housingLoanRepository = new HousingLoanRepository();
    Collegian collegian = new Collegian();

    @Override
    public void saveNewHousingLoan(HousingLoan housingLoan) throws HousingLoanException {
        if (collegian.getMaritalStatus().equals(MaritalStatus.MARRIED) && !collegian.isDormitoryResident()) {
            if (housingLoan.getCityType().equals(CityType.TEHRAN)) {
                housingLoan.setAmount(32000000);
            } else if (housingLoan.getCityType().equals(CityType.BIG_CITY)) {
                housingLoan.setAmount(26000000);
            } else if (housingLoan.getCityType().equals(CityType.OTHER_CITY)) {
                housingLoan.setAmount(19500000);
            }
            housingLoanRepository.creat(housingLoan);
        } else throw new HousingLoanException("You must be married and shouldn't be dormitory!");
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
}
