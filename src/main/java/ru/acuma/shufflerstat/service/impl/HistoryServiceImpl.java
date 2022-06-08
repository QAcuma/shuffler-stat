package ru.acuma.shufflerstat.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.web.GameData;
import ru.acuma.shufflerlib.repository.RatingHistoryRepository;
import ru.acuma.shufflerstat.service.HistoryService;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private final RatingHistoryRepository ratingHistoryRepository;

    @Override
    public GameData getGames(Filter filter) {
        return new GameData(ratingHistoryRepository.findHistory(filter));
    }
}
