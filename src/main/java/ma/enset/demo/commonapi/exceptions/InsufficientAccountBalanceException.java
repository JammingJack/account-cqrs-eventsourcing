package ma.enset.demo.commonapi.exceptions;

public class InsufficientAccountBalanceException extends RuntimeException {
    public InsufficientAccountBalanceException(String s) {
        super(s);
    }
}
