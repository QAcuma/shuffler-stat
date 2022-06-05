package ru.acuma.shufflerstat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.acuma.shufflerstat.model.web.WebResponse;
import ru.acuma.shufflerstat.model.web.WebSeason;
import ru.acuma.shufflerstat.service.SeasonService;

import java.util.List;

import static ru.acuma.shufflerstat.controller.SeasonController.SEASONS;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping(SEASONS)
@RequiredArgsConstructor
public class SeasonController {

    private final SeasonService seasonService;

    public static final String SEASONS = "/seasons";

    @GetMapping
    public ResponseEntity<WebResponse<List<WebSeason>>> getSeasons() {
        return new ResponseEntity<>(
                new WebResponse<>(seasonService.getSeasons()),
                HttpStatus.OK
        );
    }

}
