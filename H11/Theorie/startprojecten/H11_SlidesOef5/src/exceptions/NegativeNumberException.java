package exceptions;

public class NegativeNumberException extends Exception{
    public NegativeNumberException() {
        this("Moet positief zijn");
    }

    public NegativeNumberException(String msg) {
        super(msg);
    }

    public NegativeNumberException(Throwable cause) {
        super(cause);
    }

    public NegativeNumberException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public NegativeNumberException(String msg, Throwable cause, boolean enableSupression, boolean writeableStackTrace) {
        super(msg, cause, enableSupression, writeableStackTrace);
    }
}
