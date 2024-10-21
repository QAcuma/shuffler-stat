package ru.acuma.shufflerstat.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Accessors(chain = true)
public class WebGraph {

    private List<WebCoordinate> coordinates;

}
