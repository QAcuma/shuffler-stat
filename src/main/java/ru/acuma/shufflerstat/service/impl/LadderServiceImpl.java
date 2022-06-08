package ru.acuma.shufflerstat.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.web.entity.WebPlayer;
import ru.acuma.shufflerlib.model.web.wrapper.LadderData;
import ru.acuma.shufflerlib.repository.SeasonRepository;
import ru.acuma.shufflerlib.repository.StatisticRepository;
import ru.acuma.shufflerstat.mapper.StatisticMapper;
import ru.acuma.shufflerstat.service.LadderService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LadderServiceImpl implements LadderService {

    private final StatisticMapper statisticMapper;
    private final SeasonRepository seasonRepository;
    private final StatisticRepository statisticRepository;

    @Override
    public LadderData getLadder(Filter filter) {
        validateFilter(filter);
        List<WebPlayer> players = statisticRepository.findAllByFilter(filter)
                .stream()
                .map(statisticMapper::toWebPlayer)
                .sorted(Comparator.comparingInt(WebPlayer::getScore).reversed())
                .collect(Collectors.toList());

        return new LadderData(players);
    }

    private void validateFilter(Filter filter) {
        if (filter.getSeasonId() == null) {
            filter.setSeasonId(seasonRepository.getCurrentSeason().getId());
        }
    }
}
