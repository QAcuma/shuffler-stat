package ru.acuma.shufflerstat.service;

import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.web.wrapper.GameData;
import ru.acuma.shufflerlib.model.web.wrapper.GraphData;

public interface HistoryService {

    GameData getGames(Filter filter);

    GraphData getGraph(Filter filter);
}
