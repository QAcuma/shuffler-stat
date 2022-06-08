package ru.acuma.shufflerstat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.acuma.shufflerlib.model.Discipline;
import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.web.wrapper.WebResponse;
import ru.acuma.shufflerlib.model.web.wrapper.LadderData;
import ru.acuma.shufflerstat.service.LadderService;

import static ru.acuma.shufflerstat.controller.LadderController.CHAT;

@RestController
@RequestMapping(CHAT)
@RequiredArgsConstructor
public class LadderController {

    private final LadderService ladderService;

    public static final String CHAT = "/chat";
    public static final String CHAT_NAME = "/{chatName}";

    @GetMapping(CHAT_NAME)
    public WebResponse<LadderData> getChatLadder(
            @PathVariable String chatName,
            @RequestParam Discipline discipline,
            @RequestParam(required = false) Long season
    ) {
        Filter filter = new Filter()
                .setChatName(chatName)
                .setDiscipline(discipline)
                .setSeasonId(season);

        return new WebResponse<>(ladderService.getLadder(filter));
    }
}
