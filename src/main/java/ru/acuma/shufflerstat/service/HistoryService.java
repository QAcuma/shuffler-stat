package ru.acuma.shufflerstat.service;

import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.web.GameData;

public interface HistoryService {
    GameData getGames(Filter filter);

}
