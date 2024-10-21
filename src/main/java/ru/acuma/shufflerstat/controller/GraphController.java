package ru.acuma.shufflerstat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.acuma.shufflerstat.model.constants.Discipline;
import ru.acuma.shufflerstat.model.Filter;
import ru.acuma.shufflerstat.model.wrapper.GraphData;
import ru.acuma.shufflerstat.model.wrapper.WebResponse;
import ru.acuma.shufflerstat.service.HistoryService;

@RestController
@RequestMapping("/graph")
@RequiredArgsConstructor
public class GraphController {

    private final HistoryService historyService;

    @GetMapping("/{playerId}")
    public WebResponse<GraphData> getGraph(
            @PathVariable Long playerId,
            @RequestParam Discipline discipline,
            @RequestParam(required = false) Long season) {
        var filter = Filter.builder()
                .playerId(playerId)
                .discipline(discipline)
                .seasonId(season)
                .build();

        return new WebResponse<>(historyService.getGraph(filter));
    }
}
