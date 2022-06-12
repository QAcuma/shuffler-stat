package ru.acuma.shufflerstat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.acuma.shufflerlib.model.Discipline;
import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.web.wrapper.GraphData;
import ru.acuma.shufflerlib.model.web.wrapper.WebResponse;
import ru.acuma.shufflerstat.service.HistoryService;

import static ru.acuma.shufflerstat.controller.GraphController.GRAPHS;

@RestController
@RequestMapping(GRAPHS)
@RequiredArgsConstructor
public class GraphController {

    public static final String GRAPHS = "/graphs";

    private final HistoryService historyService;

    @GetMapping()
    public WebResponse<GraphData> getGraphs(
            @RequestParam(required = false) Long player,
            @RequestParam Discipline discipline,
            @RequestParam(required = false) String chat,
            @RequestParam(required = false) Long season) {
        Filter filter = new Filter()
                .setPlayerId(player)
                .setDiscipline(discipline)
                .setChatName(chat)
                .setSeasonId(season);

        return new WebResponse<>(historyService.getGraphs(filter));
    }

}
