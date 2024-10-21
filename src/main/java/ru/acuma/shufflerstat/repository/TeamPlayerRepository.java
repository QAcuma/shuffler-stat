package ru.acuma.shufflerstat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.acuma.shufflerstat.model.entity.TeamPlayer;

public interface TeamPlayerRepository extends JpaRepository<TeamPlayer, Long> {
}
