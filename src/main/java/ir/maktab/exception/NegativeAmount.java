package ir.maktab.exception;

public class NegativeAmount extends Exception {
    public NegativeAmount(String errorMessage) {
        super(errorMessage);
    }
}
