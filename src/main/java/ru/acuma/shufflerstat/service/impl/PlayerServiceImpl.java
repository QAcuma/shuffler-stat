package ru.acuma.shufflerstat.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.web.wrapper.PlayerData;
import ru.acuma.shufflerlib.repository.PlayerRepository;
import ru.acuma.shufflerstat.service.PlayerService;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    @Override
    public PlayerData getPlayerDetails(Filter filter) {
        return new PlayerData(playerRepository.findPlayerInfo(filter));
    }
}
