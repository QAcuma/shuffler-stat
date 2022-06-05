package ru.acuma.shufflerstat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static ru.acuma.shufflerstat.controller.PlayerController.PLAYER;

@RestController
@RequestMapping(PLAYER)
@RequiredArgsConstructor
public class PlayerController {

    public static final String PLAYER = "/player";

}
