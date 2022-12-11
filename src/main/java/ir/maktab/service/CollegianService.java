package ir.maktab.service;

import ir.maktab.entitty.Collegian;
import ir.maktab.exception.DuplicateNationalCodeException;

public interface CollegianService {
    void signUp(Collegian collegian);

    boolean checkNationalCode(String username) throws DuplicateNationalCodeException;

    Collegian signIn(String username, String password);

    void editCollegian(Collegian collegian);

    void signOut(Collegian collegian);
}
