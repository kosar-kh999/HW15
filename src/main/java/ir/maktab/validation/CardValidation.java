package ir.maktab.validation;

import javax.xml.bind.ValidationException;

public class CardValidation {
    public static void validCardNumber(String cardNumber) throws ValidationException {
        if (!cardNumber.equals("") && cardNumber.matches("^[0-9]{16}"))
            return;
        throw new ValidationException("Credit Card number should be 16 digits");
    }
}
