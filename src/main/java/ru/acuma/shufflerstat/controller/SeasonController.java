package ru.acuma.shufflerstat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.acuma.shufflerstat.model.dto.WebSeason;
import ru.acuma.shufflerstat.model.wrapper.WebResponse;
import ru.acuma.shufflerstat.service.SeasonService;

import java.util.List;

@RestController
@RequestMapping("/seasons")
@RequiredArgsConstructor
public class SeasonController {

    private final SeasonService seasonService;

    @GetMapping
    public WebResponse<List<WebSeason>> getSeasons() {
        return new WebResponse<>(seasonService.getSeasons());
    }
}
