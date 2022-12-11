package ir.maktab.service.serviceImpl;

import ir.maktab.entitty.Account;
import ir.maktab.entitty.Collegian;
import ir.maktab.exception.DuplicateNationalCodeException;
import ir.maktab.repository.AccountRepository;
import ir.maktab.service.AccountService;

public class AccountServiceImpl implements AccountService {
    AccountRepository accountRepository = new AccountRepository();

    @Override
    public void signUp(Collegian collegian) {
        accountRepository.creat(collegian);
    }

    @Override
    public boolean checkNationalCode(String username) throws DuplicateNationalCodeException {
        return accountRepository.checkUsername(username);
    }

    @Override
    public Account signIn(String username, String password) {
        return accountRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public void editAccount(Account account) {
        accountRepository.update(account);
    }

    @Override
    public void signOut(Account account) {
        accountRepository.remove(account);
    }


}
