package org.example.error;


import org.example.label.ErrorLabel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(annotations = {ErrorLabel.class})
public class GlobalExceptionHandler {


    @ExceptionHandler(NotFoundError.class)
    public ResponseEntity<String> handleException(NotFoundError e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
    }


}
