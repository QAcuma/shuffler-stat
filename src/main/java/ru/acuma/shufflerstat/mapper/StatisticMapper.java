package ru.acuma.shufflerstat.mapper;

import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;
import ru.acuma.shufflerlib.mapper.BaseMapper;
import ru.acuma.shufflerlib.model.StatisticResult;
import ru.acuma.shufflerlib.model.web.WebPlayer;

@Component
public class StatisticMapper extends BaseMapper {

    public WebPlayer toWebPlayer(StatisticResult source) {
        mapperFactory.classMap(StatisticResult.class, WebPlayer.class)
                .field("firstName", "name")
                .byDefault()
                .register();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(source, WebPlayer.class);
    }

}
