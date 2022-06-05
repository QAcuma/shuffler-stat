package ru.acuma.shufflerstat.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.acuma.shufflerlib.repository.SeasonRepository;
import ru.acuma.shufflerstat.mapper.SeasonMapper;
import ru.acuma.shufflerstat.model.web.WebSeason;
import ru.acuma.shufflerstat.service.SeasonService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeasonServiceImpl implements SeasonService {

    private final SeasonRepository seasonRepository;
    private final SeasonMapper seasonMapper;

    @Override
    public List<WebSeason> getSeasons() {
        return seasonRepository.findSeasons()
                .stream()
                .map(seasonMapper::toWebSeason)
                .collect(Collectors.toList());

    }
}
