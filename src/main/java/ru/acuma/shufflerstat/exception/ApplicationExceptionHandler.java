package ru.acuma.shufflerstat.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.acuma.shufflerlib.exception.MissingRequireArgumentException;
import ru.acuma.shufflerlib.model.web.entity.WebError;
import ru.acuma.shufflerlib.model.web.wrapper.ErrorData;
import ru.acuma.shufflerlib.model.web.wrapper.WebResponse;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(MissingRequireArgumentException.class)
    public WebResponse<ErrorData> handleException(MissingRequireArgumentException e, HttpServletRequest request) {
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
