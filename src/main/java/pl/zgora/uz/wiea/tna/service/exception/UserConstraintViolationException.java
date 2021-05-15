package pl.zgora.uz.wiea.tna.service.exception;

public class UserConstraintViolationException extends UniqueResourceConstraintViolationException {

    public UserConstraintViolationException() {
        super("Username is already defined.");
    }
}
