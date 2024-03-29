package ru.acuma.shufflerstat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.acuma.shufflerlib.model.web.entity.WebSeason;
import ru.acuma.shufflerlib.model.web.wrapper.WebResponse;
import ru.acuma.shufflerstat.service.SeasonService;

import java.util.List;

import static ru.acuma.shufflerstat.controller.SeasonController.SEASONS;

@RestController
@RequestMapping(SEASONS)
@RequiredArgsConstructor
public class SeasonController {

    private final SeasonService seasonService;

    public static final String SEASONS = "/seasons";

    @GetMapping
    public WebResponse<List<WebSeason>> getSeasons() {
        return new WebResponse<>(seasonService.getSeasons());
    }

}
