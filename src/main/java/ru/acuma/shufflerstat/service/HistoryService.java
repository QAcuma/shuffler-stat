package ru.acuma.shufflerstat.service;

import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.web.wrapper.GameData;

public interface HistoryService {
    GameData getGames(Filter filter);

}
