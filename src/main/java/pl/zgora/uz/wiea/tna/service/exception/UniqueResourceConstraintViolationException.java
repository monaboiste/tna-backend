package pl.zgora.uz.wiea.tna.service.exception;

import me.alidg.errors.annotation.ExceptionMapping;
import org.springframework.http.HttpStatus;

@ExceptionMapping(statusCode = HttpStatus.BAD_REQUEST, errorCode = "resource.already_exists")
public class UniqueResourceConstraintViolationException extends RuntimeException {
}
