package pl.zgora.uz.wiea.tna.service.exception;

public class EmployeeNotFoundException extends ResourceNotFoundException{
    public EmployeeNotFoundException() {
        super("Employee not found.");
    }
}
