package ru.acuma.shufflerstat.model.web;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class WebMessage {

    private String text;

}
