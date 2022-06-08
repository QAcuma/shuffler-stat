package ru.acuma.shufflerstat.mapper;

import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;
import ru.acuma.shuffler.tables.pojos.Season;
import ru.acuma.shufflerlib.mapper.BaseMapper;
import ru.acuma.shufflerlib.model.web.entity.WebSeason;

@Component
public class SeasonMapper extends BaseMapper {

    public WebSeason toWebSeason(Season source) {
        mapperFactory.classMap(Season.class, WebSeason.class)
                .byDefault()
                .register();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(source, WebSeason.class);
    }

}
