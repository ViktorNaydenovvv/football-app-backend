package com.example.diplomaprojectbackend.shared.advice;

import com.example.diplomaprojectbackend.shared.exception.ActionForbiddenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ActionForbiddenAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ActionForbiddenException.class)
    public ResponseEntity<String> handleActionForbidden(ActionForbiddenException exception) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exception.getMessage());
    }
}
