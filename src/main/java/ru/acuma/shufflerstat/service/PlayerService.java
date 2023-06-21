package ru.acuma.shufflerstat.service;

import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.web.wrapper.PlayerData;

public interface PlayerService {

    PlayerData getPlayerDetails(Filter filter);
}
