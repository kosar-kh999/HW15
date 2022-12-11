package ir.maktab.service.serviceImpl;

import ir.maktab.entitty.CreditCard;
import ir.maktab.exception.ExtraAmountException;
import ir.maktab.exception.NegativeAmountException;
import ir.maktab.repository.CreditCardRepository;
import ir.maktab.service.CreditCardService;

public class CreditCardServiceImpl implements CreditCardService {
    CreditCardRepository creditCardRepository = new CreditCardRepository();

    @Override
    public void saveNewCreditCard(CreditCard creditCard) {
        creditCardRepository.creat(creditCard);
    }

    @Override
    public CreditCard findByCardNumber(String cardNumber) {
        return creditCardRepository.findByCardNumber(cardNumber);
    }

    @Override
    public void update(CreditCard creditCard) {
        creditCardRepository.update(creditCard);
    }

    @Override
    public void remove(CreditCard creditCard) {
        creditCardRepository.remove(creditCard);
    }

    @Override
    public void withdraw(CreditCard creditCard, double amount) throws ExtraAmountException, NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException("Sorry, you can not withdraw a negative amount");
        }
        if (amount > creditCard.getAmount()) {
            throw new ExtraAmountException("Your balance is not enough");
        }
        creditCard.setAmount(creditCard.getAmount() - amount);
        creditCardRepository.update(creditCard);
    }

    @Override
    public void deposit(CreditCard creditCard, double amount) throws NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException("Sorry, you can not deposit a negative amount");
        }
        creditCard.setAmount(creditCard.getAmount() - amount);
        creditCardRepository.update(creditCard);
    }
}
