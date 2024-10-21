package ru.acuma.shufflerstat.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.acuma.shufflerstat.model.dto.WebError;
import ru.acuma.shufflerstat.model.wrapper.ErrorData;
import ru.acuma.shufflerstat.model.wrapper.WebResponse;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(DataException.class)
    public WebResponse<ErrorData> handleException(DataException e, HttpServletRequest request) {
        var error = new WebError(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                e.getClass().getSimpleName(),
                e.getMessage(),
                request.getServletPath()
        );

        return new WebResponse<>(new ErrorData(error), HttpStatus.BAD_REQUEST);
    }
}
