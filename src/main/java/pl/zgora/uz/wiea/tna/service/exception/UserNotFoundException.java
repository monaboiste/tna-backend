package pl.zgora.uz.wiea.tna.service.exception;

public class UserNotFoundException extends ResourceNotFoundException {
    public UserNotFoundException() {
        super("User not found.");
    }
}
