package ru.acuma.shufflerstat.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionCause {

    SEASON_NOT_FOUND("Missing current season"),
    RATING_NOT_FOUND("Rating not found"),
    NO_WINNING_TEAM_IN_FINISHED_GAME("Missing winning team"),
    PLAYER_NOT_FOUND("Missing player with id %s");

    private final String description;

}
