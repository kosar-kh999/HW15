package ir.maktab.service.serviceImpl;

import ir.maktab.entitty.Collegian;
import ir.maktab.exception.DuplicateNationalCodeException;
import ir.maktab.repository.CollegianRepository;
import ir.maktab.service.CollegianService;

public class CollegianServiceImpl implements CollegianService {
    CollegianRepository collegianRepository = new CollegianRepository();

    @Override
    public void signUp(Collegian collegian) {
        collegianRepository.creat(collegian);
    }

    @Override
    public boolean checkNationalCode(String username) throws DuplicateNationalCodeException {
        return collegianRepository.checkUsername(username);
    }

    @Override
    public Collegian signIn(String username, String password) {
        return collegianRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public void editCollegian(Collegian collegian) {
        collegianRepository.update(collegian);
    }

    @Override
    public void signOut(Collegian collegian) {
        collegianRepository.remove(collegian);
    }


}
