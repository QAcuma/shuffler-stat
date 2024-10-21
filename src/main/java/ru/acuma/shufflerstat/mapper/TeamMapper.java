package ru.acuma.shufflerstat.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.acuma.shufflerstat.exception.DataException;
import ru.acuma.shufflerstat.exception.ExceptionCause;
import ru.acuma.shufflerstat.model.dto.WebGame;
import ru.acuma.shufflerstat.model.dto.WebPlayer;
import ru.acuma.shufflerstat.model.dto.WebTeam;
import ru.acuma.shufflerstat.model.entity.RatingHistory;
import ru.acuma.shufflerstat.model.entity.Team;

import java.util.List;
import java.util.Objects;

@Mapper(config = MapperPreset.class, uses = PlayerMapper.class)
public interface TeamMapper {

    @Named("toWebTeams")
    default List<WebTeam> toWebTeams(RatingHistory ratingHistory) {
        return ratingHistory.getGame().getTeams().stream()
                .map(this::toWebTeam)
                .toList();
    }

    @Named("toWebTeam")
    @Mapping(target = "winner", source = "isWinner")
    @Mapping(target = "players", source = "teamPlayers", qualifiedByName = "mapPlayers")
    WebTeam toWebTeam(Team team);
}
