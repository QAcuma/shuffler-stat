package ru.acuma.shufflerstat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.acuma.shufflerstat.exception.DataException;
import ru.acuma.shufflerstat.exception.ExceptionCause;
import ru.acuma.shufflerstat.mapper.SeasonMapper;
import ru.acuma.shufflerstat.model.dto.WebSeason;
import ru.acuma.shufflerstat.repository.SeasonRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SeasonService {

    private final SeasonRepository seasonRepository;
    private final SeasonMapper seasonMapper;

    public List<WebSeason> getSeasons() {
        return seasonRepository.findAll()
                .stream()
                .map(seasonMapper::toWebSeason)
                .toList();
    }

    public Long getCurrentSeasonId() {
        return seasonRepository.findFirstByOrderByStartedAtDesc()
                .orElseThrow(() -> new DataException(ExceptionCause.SEASON_NOT_FOUND))
                .getId();
    }
}
