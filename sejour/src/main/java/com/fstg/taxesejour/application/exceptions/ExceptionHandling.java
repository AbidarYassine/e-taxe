package com.fstg.taxesejour.application.exceptions;

import com.fstg.taxesejour.domaine.core.Result;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {
    /*
    Handle Validation Exception
    */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Result> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Result result = new Result();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                result.addErrorMessage(error.getDefaultMessage()));
        return new ResponseEntity<>(result, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Result> handleUserNotFoundException(UserNotFoundException ex) {
        Result result = new Result();
        result.addErrorMessage(ex.getMessage());
        result.setStatus(403);
        return new ResponseEntity<>(result, new HttpHeaders(), HttpStatus.FORBIDDEN);
    }


}
