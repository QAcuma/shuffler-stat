package ru.acuma.shufflerstat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.acuma.shufflerstat.model.constants.Discipline;
import ru.acuma.shufflerstat.model.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query("""
        select count(t.id)
        from TeamPlayer tp
            join Team t on tp.team.id = t.id
            join Game g on t.game.id = g.id
            join Event e on g.event.id = e.id
        where e.season.id = :seasonId
            and e.discipline = :discipline
            and tp.player.id = :playerId
            and t.isWinner = true
            and g.status = 'FINISHED'
        """)
    Integer findPlayerWinCount(@Param("playerId") Long playerId, @Param("discipline") Discipline discipline, @Param("seasonId") Long seasonId);

    @Query("""
        select count(t.id)
        from TeamPlayer tp
            join Team t on tp.team.id = t.id
            join Game g on t.game.id = g.id
            join Event e on g.event.id = e.id
        where e.season.id = :seasonId
            and e.discipline = :discipline
            and tp.player.id = :playerId
            and t.isWinner = false
            and g.status = 'FINISHED'
        """)
    Integer findPlayerLoseCount(@Param("playerId") Long playerId, @Param("discipline") Discipline discipline, @Param("seasonId") Long seasonId);
}
