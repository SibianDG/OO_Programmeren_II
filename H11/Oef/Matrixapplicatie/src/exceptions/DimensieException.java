package exceptions;

public class DimensieException extends IllegalArgumentException {

    public DimensieException() {
        this("De matrix heeft de verkeerde dimensies.");
    }

    public DimensieException(String s) {
        super(s);
    }

    public DimensieException(String message, Throwable cause) {
        super(message, cause);
    }

    public DimensieException(Throwable cause) {
        super(cause);
    }

}
