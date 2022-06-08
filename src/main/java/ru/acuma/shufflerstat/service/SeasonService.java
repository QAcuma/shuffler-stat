package ru.acuma.shufflerstat.service;

import ru.acuma.shufflerlib.model.web.entity.WebSeason;

import java.util.List;

public interface SeasonService {

    List<WebSeason> getSeasons();

    Long getCurrentSeasonId();

}
