package exceptions;

public class SectorMisMatchException extends IllegalArgumentException {

    public SectorMisMatchException() {
        this("Verkeerde sector");
    }

    public SectorMisMatchException(String s) {
        super(s);
    }

    public SectorMisMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public SectorMisMatchException(Throwable cause) {
        super(cause);
    }

}
