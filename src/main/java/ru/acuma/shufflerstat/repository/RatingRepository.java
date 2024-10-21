package ru.acuma.shufflerstat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.acuma.shufflerstat.model.constants.Discipline;
import ru.acuma.shufflerstat.model.entity.Rating;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query("""
            select r
            from Rating r
            where r.discipline = :discipline
                and r.season.id = :seasonId
                and r.player.chat.name = :chatName
        """)
    List<Rating> findChatRatings(
            @Param("chatName") String chatName,
            @Param("discipline") Discipline discipline,
            @Param("seasonId") Long seasonId
    );
}
