package ru.acuma.shufflerstat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.acuma.shufflerlib.model.Discipline;
import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.web.wrapper.GraphData;
import ru.acuma.shufflerlib.model.web.wrapper.WebResponse;
import ru.acuma.shufflerstat.service.HistoryService;

import static ru.acuma.shufflerstat.controller.GraphController.GRAPH;
import static ru.acuma.shufflerstat.controller.PlayerController.PLAYER_ID;

@RestController
@RequestMapping(GRAPH)
@RequiredArgsConstructor
public class GraphController {

    public static final String GRAPH = "/graph";

    private final HistoryService historyService;

    @GetMapping(PLAYER_ID)
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
