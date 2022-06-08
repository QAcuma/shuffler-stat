package ru.acuma.shufflerstat.service;

import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.web.LadderData;

public interface LadderService {

    LadderData getLadder(Filter filter);

}
