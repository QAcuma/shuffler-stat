package ru.acuma.shufflerstat.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@Accessors(chain = true)
public class WebError {

    private LocalDateTime timestamp;
    private Integer statusCode;
    private String error;
    private String message;
    private String path;

}
