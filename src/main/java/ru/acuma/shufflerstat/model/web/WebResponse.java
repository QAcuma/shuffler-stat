package ru.acuma.shufflerstat.model.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WebResponse<T> {

    private T payload;

    private List<WebError> errors;

    private WebMessage message;

    public WebResponse(T payload) {
        this.payload = payload;
    }

    public WebResponse(T payload, WebMessage message) {
        this.payload = payload;
        this.message = message;
    }

    public WebResponse(List<WebError> errors) {
        this.errors = errors;
    }

    public WebResponse(T payload, List<WebError> errors) {
        this.payload = payload;
        this.errors = errors;
    }


}
