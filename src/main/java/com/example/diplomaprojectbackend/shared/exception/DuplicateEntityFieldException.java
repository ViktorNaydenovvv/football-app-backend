package com.example.diplomaprojectbackend.shared.exception;

public class DuplicateEntityFieldException extends RuntimeException {
    public DuplicateEntityFieldException(String message) {
        super(message);
    }
}
