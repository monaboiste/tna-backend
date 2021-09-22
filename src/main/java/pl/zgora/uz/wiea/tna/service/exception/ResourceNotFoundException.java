package pl.zgora.uz.wiea.tna.service.exception;

import me.alidg.errors.annotation.ExceptionMapping;
import org.springframework.http.HttpStatus;

@ExceptionMapping(statusCode = HttpStatus.NOT_FOUND, errorCode = "resource.not_found")
public class ResourceNotFoundException extends RuntimeException {
}
