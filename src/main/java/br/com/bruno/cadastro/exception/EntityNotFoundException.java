package br.com.bruno.cadastro.exception;

import br.com.bruno.cadastro.exception.intercept.ApplicationException;
import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends ApplicationException {
    public EntityNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
