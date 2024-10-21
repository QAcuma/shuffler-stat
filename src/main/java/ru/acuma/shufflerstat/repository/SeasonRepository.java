package ru.acuma.shufflerstat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.acuma.shufflerstat.model.entity.Season;

import java.util.Optional;

public interface SeasonRepository extends JpaRepository<Season, Long> {

    Optional<Season> findFirstByOrderByStartedAtDesc();
}
