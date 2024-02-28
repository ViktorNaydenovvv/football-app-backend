package com.example.diplomaprojectbackend.shared.exception;

public class ActionForbiddenException extends RuntimeException {
    public ActionForbiddenException(String message) { super(message); }
}
