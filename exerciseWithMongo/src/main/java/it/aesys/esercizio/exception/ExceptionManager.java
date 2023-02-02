package it.aesys.esercizio.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionManager {

    @ExceptionHandler(BadInputException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(Exception e) {
        ErrorResponse response = new ErrorResponse();
        response.setError("Bad Input");
        response.setStatus(400);
        response.setMessage(e.getMessage());
        response.setTime(LocalDateTime.now());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointer(Exception e) {
        ErrorResponse response = new ErrorResponse();
        response.setError("Empty Response");
        response.setStatus(404);
        response.setMessage(e.getMessage());
        response.setTime(LocalDateTime.now());
        return ResponseEntity.badRequest().body(response);
    }
}
