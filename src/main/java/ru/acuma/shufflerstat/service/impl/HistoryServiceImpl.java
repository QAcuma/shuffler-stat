package ru.acuma.shufflerstat.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.web.wrapper.GameData;
import ru.acuma.shufflerlib.model.web.wrapper.GraphData;
import ru.acuma.shufflerlib.repository.RatingHistoryRepository;
import ru.acuma.shufflerlib.repository.StatisticRepository;
import ru.acuma.shufflerstat.service.FilterService;
import ru.acuma.shufflerstat.service.HistoryService;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private final RatingHistoryRepository ratingHistoryRepository;
    private final StatisticRepository statisticRepository;
    private final FilterService filterService;

    @Override
    public GameData getGames(Filter filter) {
        filterService.fillDefaults(filter);
        var gameHistory = ratingHistoryRepository.findHistory(filter);

        return new GameData(gameHistory);
    }

    @Override
    public GraphData getGraph(Filter filter) {
        filterService.fillDefaults(filter);

        return new GraphData(statisticRepository.buildGraphData(filter));
    }
}
