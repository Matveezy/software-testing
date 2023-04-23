package exception;

import org.openqa.selenium.InvalidArgumentException;

public class InvalidCoreException extends IllegalArgumentException {

    protected String message;

    public InvalidCoreException(String message) {
        this.message = message;
    }

    public InvalidCoreException() {
        message = "Invalid.";
    }

    public String getMessage() {
        return message;
    }
}
