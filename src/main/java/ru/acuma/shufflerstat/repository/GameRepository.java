package ru.acuma.shufflerstat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.acuma.shufflerstat.model.entity.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
}
