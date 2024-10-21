package ru.acuma.shufflerstat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.acuma.shufflerstat.mapper.GameMapper;
import ru.acuma.shufflerstat.model.Filter;
import ru.acuma.shufflerstat.model.wrapper.GameData;
import ru.acuma.shufflerstat.model.wrapper.GraphData;
import ru.acuma.shufflerstat.repository.RatingHistoryRepository;

@Service
@RequiredArgsConstructor
public class HistoryService {

    private final RatingHistoryRepository ratingHistoryRepository;
    private final GameMapper gameMapper;
    private final FilterService filterService;

    public GameData getGames(Filter filter) {
        filterService.fillDefaults(filter);
        var webGames = ratingHistoryRepository.findPlayerHistory(
                        filter.getPlayerId(),
                        filter.getDiscipline(),
                        filter.getSeasonId()
                ).stream()
                .map(gameMapper::toWebGames)
                .toList();

        return new GameData(webGames);
    }

    public GraphData getGraph(Filter filter) {
        filterService.fillDefaults(filter);

        return null;
    }
}
