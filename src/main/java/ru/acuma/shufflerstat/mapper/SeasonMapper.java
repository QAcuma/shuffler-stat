package ru.acuma.shufflerstat.mapper;

import jakarta.persistence.MappedSuperclass;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.acuma.shufflerstat.model.dto.WebSeason;
import ru.acuma.shufflerstat.model.entity.Season;

@Mapper(config = MapperPreset.class)
public interface SeasonMapper {

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    WebSeason toWebSeason(Season season);
}
