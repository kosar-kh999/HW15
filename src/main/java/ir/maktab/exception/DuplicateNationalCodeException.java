package ir.maktab.exception;

public class DuplicateNationalCodeException extends Exception {
    public DuplicateNationalCodeException(String errorMessage) {
        super(errorMessage);
    }
}
