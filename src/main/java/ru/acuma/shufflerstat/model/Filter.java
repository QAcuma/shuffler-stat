package ru.acuma.shufflerstat.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.acuma.shufflerstat.model.constants.Discipline;

@Getter
@Setter
@Builder
@Accessors(chain = true)
public class Filter {

    private Discipline discipline;
    private String chatName;
    private Long chatId;
    private Long playerId;
    private Long gameId;
    private Long seasonId;

}
