package ir.maktab.service;

import ir.maktab.entitty.Account;
import ir.maktab.entitty.Collegian;
import ir.maktab.exception.DuplicateNationalCodeException;

public interface AccountService {
    void signUp(Collegian collegian);

    boolean checkNationalCode(String username) throws DuplicateNationalCodeException;

    Account signIn(String username, String password);

    void editAccount(Account account);

    void signOut(Account account);
}
