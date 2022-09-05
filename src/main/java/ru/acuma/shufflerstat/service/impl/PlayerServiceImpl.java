package ru.acuma.shufflerstat.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.web.entity.WebPlayer;
import ru.acuma.shufflerlib.model.web.wrapper.PlayerData;
import ru.acuma.shufflerlib.repository.PlayerRepository;
import ru.acuma.shufflerstat.service.FilterService;
import ru.acuma.shufflerstat.service.PlayerService;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final FilterService filterService;
    private final PlayerRepository playerRepository;

    @Override
    public PlayerData getPlayerDetails(Filter filter) {
        filterService.fillDefaults(filter);
        var player = playerRepository.findPlayerInfo(filter);
        secureScoreOnCalibration(player);

        return new PlayerData(player);
    }

    @Override
    public void secureScoreOnCalibration(WebPlayer player) {
        var score = player.getIsCalibrated() ? player.getScore() : 0;

        player.setScore(score);
    }
}
