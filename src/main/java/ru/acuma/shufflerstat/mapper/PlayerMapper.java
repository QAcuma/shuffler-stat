package ru.acuma.shufflerstat.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.acuma.shufflerstat.model.Filter;
import ru.acuma.shufflerstat.model.dto.WebPlayer;
import ru.acuma.shufflerstat.model.entity.Player;
import ru.acuma.shufflerstat.model.entity.Rating;
import ru.acuma.shufflerstat.model.entity.RatingHistory;
import ru.acuma.shufflerstat.model.entity.TeamPlayer;
import ru.acuma.shufflerstat.model.entity.UserInfo;

import java.util.List;
import java.util.Objects;

@Mapper(config = MapperPreset.class)
public interface PlayerMapper {

    @Mapping(target = "id", source = "player.id")
    @Mapping(target = "name", source = "player.user", qualifiedByName = "mapName")
    @Mapping(target = "avatar", source = "player.user.mediaId")
    @Mapping(target = "score", source = "player.ratings", qualifiedByName = "mapScore")
    @Mapping(target = "winCount", source = "winCount")
    @Mapping(target = "loseCount", source = "loseCount")
    WebPlayer toWebPlayer(Player player, Integer winCount, Integer loseCount, @Context Filter filter);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "player.id")
    @Mapping(target = "name", source = "player.user", qualifiedByName = "mapName")
    @Mapping(target = "avatar", source = "player.user.mediaId")
    @Mapping(target = "score", source = "score")
    WebPlayer toWebPlayer(Player player, Integer score);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "player.id")
    @Mapping(target = "name", source = "player.user", qualifiedByName = "mapName")
    @Mapping(target = "avatar", source = "player.user.mediaId")
    @Mapping(target = "score", source = "score")
    WebPlayer toWebPlayer(Rating rating);

    @Named("mapPlayers")
    default List<WebPlayer> mapPlayers(List<TeamPlayer> teamPlayers, @Context List<RatingHistory> histories) {
        return teamPlayers.stream()
                .map(TeamPlayer::getPlayer)
                .map(player -> {
                    var score = extractPlayerHistoryScore(player, histories);
                    return toWebPlayer(player, score);
                })
                .toList();
    }

    default Integer extractPlayerHistoryScore(Player player, List<RatingHistory> histories) {
        return histories.stream()
                .filter(history -> history.getPlayer().equals(player))
                .findFirst()
                .map(RatingHistory::getChange)
                .orElse(0);
    }

    @Named("mapName")
    default String mapName(UserInfo userInfo) {
        return "%s %s".formatted(userInfo.getFirstName(), userInfo.getLastName())
                .replaceAll("null", "")
                .trim();
    }

    @Named("mapScore")
    default Integer mapScore(List<Rating> ratings, @Context Filter filter) {
        return ratings.stream()
                .filter(rating -> Objects.equals(filter.getDiscipline(), rating.getDiscipline()))
                .filter(rating -> Objects.equals(filter.getSeasonId(), rating.getSeason().getId()))
                .findFirst()
                .map(Rating::getScore)
                .orElse(1000);
    }
}
