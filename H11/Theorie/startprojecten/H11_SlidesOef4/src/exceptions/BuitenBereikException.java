package exceptions;

public class BuitenBereikException extends IllegalArgumentException{
    public BuitenBereikException() {
        this("respecteer interval");
    }

    public BuitenBereikException(String msg) {
        super(msg);
    }

    public BuitenBereikException(Throwable cause) {
        super(cause);
    }

    public BuitenBereikException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
