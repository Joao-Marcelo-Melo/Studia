package com.jmz.studia.infra.exceptions;

import com.jmz.studia.errors.CourseNotFoundException;
import com.jmz.studia.errors.ModuleNotFoundException;
import com.jmz.studia.errors.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({UserNotFoundException.class})
    private ResponseEntity<RestErrorMessage> userNotFoundHandler(UserNotFoundException exception) {
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restErrorMessage);
    }

    @ExceptionHandler({CourseNotFoundException.class})
    private ResponseEntity<RestErrorMessage> courseNotFoundHandler(CourseNotFoundException exception) {
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restErrorMessage);
    }

    @ExceptionHandler({ModuleNotFoundException.class})
    private ResponseEntity<RestErrorMessage> moduleNotFoundHandler(ModuleNotFoundException exception) {
        RestErrorMessage restErrorMessage = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(restErrorMessage);
    }
}
