package ru.acuma.shufflerstat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.acuma.shufflerstat.exception.DataException;
import ru.acuma.shufflerstat.exception.ExceptionCause;
import ru.acuma.shufflerstat.mapper.PlayerMapper;
import ru.acuma.shufflerstat.model.Filter;
import ru.acuma.shufflerstat.model.wrapper.PlayerData;
import ru.acuma.shufflerstat.repository.PlayerRepository;
import ru.acuma.shufflerstat.repository.TeamRepository;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final FilterService filterService;
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final PlayerMapper playerMapper;

    @Transactional(readOnly = true)
    public PlayerData getPlayerDetails(Filter filter) {
        filterService.fillDefaults(filter);
        var player = playerRepository.findById(filter.getPlayerId())
                .orElseThrow(() -> new DataException(ExceptionCause.PLAYER_NOT_FOUND, filter.getPlayerId()));
        var winCount = teamRepository.findPlayerWinCount(filter.getPlayerId(), filter.getDiscipline(), filter.getSeasonId());
        var loseCount = teamRepository.findPlayerLoseCount(filter.getPlayerId(), filter.getDiscipline(), filter.getSeasonId());
        var webPlayer = playerMapper.toWebPlayer(player, winCount, loseCount, filter);

        return new PlayerData(webPlayer);
    }
}
