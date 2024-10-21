package ru.acuma.shufflerstat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.acuma.shufflerstat.model.constants.Discipline;
import ru.acuma.shufflerstat.model.entity.RatingHistory;

import java.util.List;

public interface RatingHistoryRepository extends JpaRepository<RatingHistory, Long> {

    @Query("""
            select rh
            from RatingHistory rh
            where rh.season.id = :seasonId
                and rh.player.id = :playerId
                and rh.discipline = :discipline
                and rh.game.status = 'FINISHED'
            """)
    List<RatingHistory> findPlayerHistory(
            @Param("playerId") Long playerId,
            @Param("discipline") Discipline discipline,
            @Param("seasonId") Long seasonId
    );
}
