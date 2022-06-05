package ru.acuma.shufflerstat.model.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WebResponse<T> {

    private T data;

    private List<WebError> errors;

    private WebMessage message;

    public WebResponse(T data) {
        this.data = data;
    }

    public WebResponse(T data, WebMessage message) {
        this.data = data;
        this.message = message;
    }

    public WebResponse(List<WebError> errors) {
        this.errors = errors;
    }

    public WebResponse(T data, List<WebError> errors) {
        this.data = data;
        this.errors = errors;
    }


}
