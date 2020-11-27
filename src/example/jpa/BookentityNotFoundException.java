package example.jpa;

public class BookentityNotFoundException extends RuntimeException {

    public BookentityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public BookentityNotFoundException(String message) {
        super(message);
    }
    // ...
}
