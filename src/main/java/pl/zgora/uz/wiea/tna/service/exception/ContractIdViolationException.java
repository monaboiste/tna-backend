package pl.zgora.uz.wiea.tna.service.exception;

public class ContractIdViolationException extends UniqueResourceConstraintViolationException {

    public ContractIdViolationException() {
        super("Contract id must be unique and match pattern '^[A-Za-z0-9]{3,}$'");
    }
}
