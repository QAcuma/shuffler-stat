package ru.acuma.shufflerstat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.acuma.shufflerstat.mapper.DisciplineToEnumConvertor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DisciplineToEnumConvertor());
    }
}
