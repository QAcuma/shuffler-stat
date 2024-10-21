package ru.acuma.shufflerstat.model.entity;

import jakarta.persistence.Cacheable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Getter
@Setter
@Accessors(chain = true)
@ToString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "team")
@DynamicUpdate
@DynamicInsert

@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Team extends BaseEntity {

    @NotNull
    @ToString.Exclude
    @Fetch(FetchMode.JOIN)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @Column(name = "is_winner")
    private Boolean isWinner;

    @NotNull
    @OneToMany(mappedBy = "team")
    @ToString.Exclude
    private List<TeamPlayer> teamPlayers;
}
