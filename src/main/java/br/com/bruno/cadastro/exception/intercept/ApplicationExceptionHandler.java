package br.com.bruno.cadastro.exception.intercept;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> handleException(Exception e, HttpServletRequest request) {

        if (e instanceof ApplicationException) {
            StandardError standardError = new StandardError(Instant.now(),
                    ((ApplicationException) e).getHttpStatus().value(),
                    e.getLocalizedMessage(),
                    e.getMessage(),
                    request.getRequestURI());
            return ResponseEntity.status(standardError.getStatus()).body(standardError);
        }

        StandardError standardError = new StandardError(Instant.now(),
                500,
                e.getLocalizedMessage(),
                "Ocorreu um erro inesperado!",
                request.getRequestURI());

        e.printStackTrace();

        return ResponseEntity.status(standardError.getStatus()).body(standardError);
    }
}
