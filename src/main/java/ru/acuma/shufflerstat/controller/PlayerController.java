package ru.acuma.shufflerstat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.acuma.shufflerlib.model.Discipline;
import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.web.wrapper.PlayerData;
import ru.acuma.shufflerlib.model.web.wrapper.WebResponse;
import ru.acuma.shufflerstat.service.PlayerService;

import static ru.acuma.shufflerstat.controller.PlayerController.PLAYER;

@RestController
@RequestMapping(PLAYER)
@RequiredArgsConstructor
public class PlayerController {

    public static final String PLAYER = "/player";
    public static final String PLAYER_ID = "/{playerId}";

    private final PlayerService playerService;

    @GetMapping(PLAYER_ID)
    public WebResponse<PlayerData> getHistory(
            @PathVariable Long playerId,
            @RequestParam Discipline discipline,
            @RequestParam(required = false) Long season) {
        var filter = Filter.builder()
                .playerId(playerId)
                .discipline(discipline)
                .seasonId(season)
                .build();

        return new WebResponse<>(playerService.getPlayerDetails(filter));
    }

}
