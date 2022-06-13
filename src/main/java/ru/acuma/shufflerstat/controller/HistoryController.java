package ru.acuma.shufflerstat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.acuma.shufflerlib.model.Discipline;
import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.web.wrapper.GameData;
import ru.acuma.shufflerlib.model.web.wrapper.WebResponse;
import ru.acuma.shufflerstat.service.HistoryService;

import static ru.acuma.shufflerstat.controller.HistoryController.HISTORY;
import static ru.acuma.shufflerstat.controller.PlayerController.PLAYER_ID;

@RestController
@RequestMapping(HISTORY)
@RequiredArgsConstructor
public class HistoryController {

    private final HistoryService historyService;

    public static final String HISTORY = "/history";

    @GetMapping(PLAYER_ID)
    public WebResponse<GameData> getHistory(
            @PathVariable Long playerId,
            @RequestParam Discipline discipline,
            @RequestParam(required = false) Long season) {
        Filter filter = new Filter()
                .setPlayerId(playerId)
                .setDiscipline(discipline)
                .setSeasonId(season);

        return new WebResponse<>(historyService.getGames(filter));
    }

}
