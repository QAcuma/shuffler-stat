package ru.acuma.shufflerstat.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.web.WebGame;
import ru.acuma.shufflerlib.repository.RatingHistoryRepository;
import ru.acuma.shufflerstat.service.HistoryService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private final RatingHistoryRepository ratingHistoryRepository;

    @Override
    public List<WebGame> getGames(Filter filter) {
        return ratingHistoryRepository.findHistory(filter);
    }
}
