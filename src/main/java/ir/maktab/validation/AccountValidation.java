package ir.maktab.validation;

import javax.xml.bind.ValidationException;
import java.util.regex.Pattern;

public class AccountValidation {
    public static void checkPassword(String password) throws ValidationException {
        if (!Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[@#$%&])(?=\\S+$).{8}$",
                password))
            throw new ValidationException("Your password is not valid");
    }

    public static boolean nationalCodeValid(String nationalCode) {
        return !nationalCode.equals("") && nationalCode.matches("^([0-9]){10}$");
    }
}
