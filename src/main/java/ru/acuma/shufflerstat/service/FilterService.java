package ru.acuma.shufflerstat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.acuma.shufflerstat.model.Filter;


@Service
@RequiredArgsConstructor
public class FilterService {

    private final SeasonService seasonService;

    public void fillDefaults(Filter filter) {
        if (filter.getSeasonId() == null) {
            filter.setSeasonId(seasonService.getCurrentSeasonId());
        }
    }
}
