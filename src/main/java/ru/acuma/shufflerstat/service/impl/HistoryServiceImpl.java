package ru.acuma.shufflerstat.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.web.entity.WebGame;
import ru.acuma.shufflerlib.model.web.entity.WebPlayer;
import ru.acuma.shufflerlib.model.web.wrapper.GameData;
import ru.acuma.shufflerlib.model.web.wrapper.GraphData;
import ru.acuma.shufflerlib.repository.RatingHistoryRepository;
import ru.acuma.shufflerlib.repository.StatisticRepository;
import ru.acuma.shufflerstat.service.FilterService;
import ru.acuma.shufflerstat.service.HistoryService;
import ru.acuma.shufflerstat.service.PlayerService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private final RatingHistoryRepository ratingHistoryRepository;
    private final StatisticRepository statisticRepository;
    private final FilterService filterService;
    private final PlayerService playerService;

    @Override
    public GameData getGames(Filter filter) {
        filterService.fillDefaults(filter);
        var gameHistory = ratingHistoryRepository.findHistory(filter);
        secureGameScoreOnCalibration(gameHistory, filter);

        return new GameData(gameHistory);
    }

    @Override
    public GraphData getGraph(Filter filter) {
        filterService.fillDefaults(filter);

        return new GraphData(statisticRepository.buildGraphData(filter));
    }

    private void secureGameScoreOnCalibration(List<WebGame> gameHistory, Filter filter) {
        var player = playerService.getPlayerDetails(filter);
        gameHistory.stream()
                .flatMap(game -> game.getTeams().stream())
                .flatMap(team -> team.getPlayers().stream())
                .forEach(playerService::secureScoreOnCalibration);
        gameHistory.stream()
                .filter(game -> containsCalibratingPlayer(game, player.getPlayer()))
                .forEach(game -> game.setChange(0));
    }

    private boolean containsCalibratingPlayer(WebGame game, WebPlayer webPlayer) {
        if (webPlayer.getIsCalibrated()) {
            return false;
        }
        return game.getTeams().stream()
                .flatMap(team -> team.getPlayers().stream())
                .anyMatch(player -> player.getId().equals(webPlayer.getId()));
    }
}
