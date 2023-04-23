package exception;

public class InvalidPropertiesException extends InvalidCoreException {

    public InvalidPropertiesException(String message) {
        super(message);
    }

    public InvalidPropertiesException() {
        super.message = "Empry props file";
    }
}
