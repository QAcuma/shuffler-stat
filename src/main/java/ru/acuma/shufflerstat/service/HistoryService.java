package ru.acuma.shufflerstat.service;

import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.web.WebGame;

import java.util.List;

public interface HistoryService {

    List<WebGame> getGames(Filter filter);


}
