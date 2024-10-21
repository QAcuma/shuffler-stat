package ru.acuma.shufflerstat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.acuma.shufflerstat.mapper.PlayerMapper;
import ru.acuma.shufflerstat.model.Filter;
import ru.acuma.shufflerstat.model.dto.WebPlayer;
import ru.acuma.shufflerstat.model.wrapper.LadderData;
import ru.acuma.shufflerstat.repository.PlayerRepository;
import ru.acuma.shufflerstat.repository.RatingRepository;
import ru.acuma.shufflerstat.repository.SeasonRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LadderService {

    private final RatingRepository ratingRepository;
    private final FilterService filterService;
    private final PlayerMapper playerMapper;

    public LadderData getLadder(Filter filter) {
        filterService.fillDefaults(filter);
        var players = ratingRepository.findChatRatings(filter.getChatName(), filter.getDiscipline(), filter.getSeasonId())
                .stream()
                .map(playerMapper::toWebPlayer)
                .sorted(Comparator.comparingInt(WebPlayer::getScore).reversed())
                .toList();

        return new LadderData(players);
    }
}
