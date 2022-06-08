package ru.acuma.shufflerstat.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerstat.service.FilterService;
import ru.acuma.shufflerstat.service.SeasonService;


@Service
@RequiredArgsConstructor
public class FilterServiceImpl implements FilterService {

    private final SeasonService seasonService;

    @Override
    public void fillDefaults(Filter filter) {
        if (filter.getSeasonId() == null) {
            filter.setSeasonId(seasonService.getCurrentSeasonId());
        }

    }

}
