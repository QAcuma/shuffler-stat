package ru.acuma.shufflerstat.mapper;

import org.springframework.core.convert.converter.Converter;
import ru.acuma.shufflerstat.model.constants.Discipline;

public class DisciplineToEnumConvertor implements Converter<String, Discipline> {

    @Override
    public Discipline convert(String source) {
        return Discipline.getByWebName(source);
    }
}
