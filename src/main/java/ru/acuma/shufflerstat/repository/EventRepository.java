package ru.acuma.shufflerstat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.acuma.shufflerstat.model.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
