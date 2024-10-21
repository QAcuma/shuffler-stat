package ru.acuma.shufflerstat.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.acuma.shufflerstat.model.dto.WebGame;
import ru.acuma.shufflerstat.model.entity.RatingHistory;
import ru.acuma.shufflerstat.model.wrapper.GameData;

@Mapper(
        config = MapperPreset.class,
        uses = TeamMapper.class
)
public interface GameMapper {

    @Mapping(target = "id", source = "game.id")
    @Mapping(target = "date", source = "game.finishedAt")
    @Mapping(target = "change", source = "change")
    @Mapping(target = "teams", source = "ratingHistory", qualifiedByName = "toWebTeams")
    WebGame toWebGames(RatingHistory ratingHistory);
}
