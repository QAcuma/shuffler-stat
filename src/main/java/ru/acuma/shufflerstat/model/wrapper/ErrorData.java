package ru.acuma.shufflerstat.model.wrapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.acuma.shufflerstat.model.dto.WebError;

@Getter
@Setter
@AllArgsConstructor
@Accessors(chain = true)
public class ErrorData {

    private WebError error;

}
