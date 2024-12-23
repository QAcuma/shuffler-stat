package ru.acuma.shufflerstat.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@MappedSuperclass
public abstract class BaseEntityC extends BaseEntity {

    @Column(name = "started_at", nullable = false)
    private LocalDateTime startedAt;
}
