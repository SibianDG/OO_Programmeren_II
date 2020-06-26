package exceptions;

public class FormaatException extends Exception {
  public FormaatException() {
      this("respecteer interval");
  }

  public FormaatException(String msg) {
      super(msg);
  }

  public FormaatException(Throwable cause) {
      super(cause);
  }

  public FormaatException(String msg, Throwable cause) {
      super(msg, cause);
  }
}
