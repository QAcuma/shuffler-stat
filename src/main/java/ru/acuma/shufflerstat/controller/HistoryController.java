package ru.acuma.shufflerstat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.acuma.shufflerstat.model.constants.Discipline;
import ru.acuma.shufflerstat.model.Filter;
import ru.acuma.shufflerstat.model.wrapper.GameData;
import ru.acuma.shufflerstat.model.wrapper.WebResponse;
import ru.acuma.shufflerstat.service.HistoryService;

@RestController
@RequestMapping("/history")
@RequiredArgsConstructor
public class HistoryController {

    private final HistoryService historyService;

    @GetMapping("/{playerId}")
    public WebResponse<GameData> getHistory(
            @PathVariable(required = false) Long playerId,
            @RequestParam Discipline discipline,
            @RequestParam(required = false) Long season) {
        var filter = Filter.builder()
                .playerId(playerId)
                .discipline(discipline)
                .seasonId(season)
                .build();

        return new WebResponse<>(historyService.getGames(filter));
    }
}
