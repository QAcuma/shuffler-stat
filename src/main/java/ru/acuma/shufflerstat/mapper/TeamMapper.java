package ru.acuma.shufflerstat.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.acuma.shufflerstat.model.dto.WebTeam;
import ru.acuma.shufflerstat.model.entity.RatingHistory;
import ru.acuma.shufflerstat.model.entity.Team;

import java.util.List;

@Mapper(config = MapperPreset.class, uses = PlayerMapper.class)
public interface TeamMapper {

    @Named("toWebTeams")
    default List<WebTeam> toWebTeams(RatingHistory ratingHistory) {
        var game = ratingHistory.getGame();

        return game.getTeams().stream()
                .map(team -> toWebTeam(team, game.getHistories()))
                .toList();
    }

    @Named("toWebTeam")
    @Mapping(target = "winner", source = "isWinner")
    @Mapping(target = "players", source = "teamPlayers", qualifiedByName = "mapPlayers")
    WebTeam toWebTeam(Team team, @Context List<RatingHistory> histories);
}
