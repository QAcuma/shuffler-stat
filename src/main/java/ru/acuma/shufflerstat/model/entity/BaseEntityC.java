package ru.acuma.shufflerstat.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ru.acuma.shufflerstat.util.TimeMachine;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@MappedSuperclass
public abstract class BaseEntityC extends BaseEntity {

    @NotNull
    @Column(name = "started_at", nullable = false)
    private LocalDateTime startedAt;
}
