package ir.maktab.service;

import ir.maktab.entitty.CreditCard;
import ir.maktab.exception.ExtraAmount;
import ir.maktab.exception.NegativeAmount;

public interface CreditCardService {
    void saveNewCreditCard(CreditCard creditCard);

    CreditCard findByCardNumber(String cardNumber);

    void update(CreditCard creditCard);

    void remove(CreditCard creditCard);

    void withdraw(CreditCard creditCard, double amount) throws ExtraAmount, NegativeAmount;

    void deposit(CreditCard creditCard, double amount) throws NegativeAmount;
}
