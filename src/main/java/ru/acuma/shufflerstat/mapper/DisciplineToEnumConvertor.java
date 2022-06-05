package ru.acuma.shufflerstat.mapper;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import ru.acuma.shufflerlib.model.Discipline;

public class DisciplineToEnumConvertor implements Converter<String, Discipline> {

    @Override
    public Discipline convert(@NotNull String source) {
        return Discipline.getByWebName(source);
    }
}
