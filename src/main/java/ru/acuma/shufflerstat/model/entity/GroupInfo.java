package ru.acuma.shufflerstat.model.entity;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

@Getter
@Setter
@Accessors(chain = true)
@ToString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "group_info")
@DynamicUpdate
@DynamicInsert

@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class GroupInfo {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", length = Integer.MAX_VALUE)
    private String title;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "name", length = 16)
    private String name;
}
