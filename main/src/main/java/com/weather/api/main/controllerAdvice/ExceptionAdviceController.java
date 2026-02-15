package com.weather.api.main.controllerAdvice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.weather.api.main.error.ErrorDetails;
import com.weather.api.main.error.InvalidDateFormatException;

@RestControllerAdvice
public class ExceptionAdviceController {

    @ExceptionHandler(InvalidDateFormatException.class)
    public ResponseEntity<ErrorDetails> exceptionInvalidDateFormat() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setErrorDetails(
                "Wrong date format given. Date format must match either yyyy-mm-dd or yyyy-mm-ddTHH:mm:ss");
        return ResponseEntity.badRequest().body(
                errorDetails);
    }

}
