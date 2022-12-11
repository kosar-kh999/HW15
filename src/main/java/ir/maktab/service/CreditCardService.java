package ir.maktab.service;

import ir.maktab.entitty.CreditCard;
import ir.maktab.exception.ExtraAmountException;
import ir.maktab.exception.NegativeAmountException;

public interface CreditCardService {
    void saveNewCreditCard(CreditCard creditCard);

    CreditCard findByCardNumber(String cardNumber);

    void update(CreditCard creditCard);

    void remove(CreditCard creditCard);

    void withdraw(CreditCard creditCard, double amount) throws ExtraAmountException, NegativeAmountException;

    void deposit(CreditCard creditCard, double amount) throws NegativeAmountException;
}
