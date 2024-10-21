package ru.acuma.shufflerstat.exception;

import lombok.Getter;

public class DataException extends RuntimeException {

    private final String message;
    @Getter
    private final ExceptionCause exceptionCause;

    public DataException(ExceptionCause exceptionCause, Object... args) {
        this.exceptionCause = exceptionCause;
        message = exceptionCause.getDescription().formatted(args);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
