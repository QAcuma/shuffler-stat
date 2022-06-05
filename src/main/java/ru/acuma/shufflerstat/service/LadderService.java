package ru.acuma.shufflerstat.service;

import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerstat.model.web.WebLadder;

public interface LadderService {

    WebLadder getLadder(Filter filter);

}
