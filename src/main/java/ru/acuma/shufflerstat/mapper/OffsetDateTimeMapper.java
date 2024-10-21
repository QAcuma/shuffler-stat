package ru.acuma.shufflerstat.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OffsetDateTimeMapper {

    default OffsetDateTime map(LocalDateTime source) {
        return source == null
                ? null
                : source.atZone(ZoneId.systemDefault()).toOffsetDateTime();
    }

    default LocalDateTime map(OffsetDateTime source) {
        return source == null
                ? null
                : source.toLocalDateTime();
    }

    default Timestamp mapTimestamp(LocalDateTime source) {
        return source == null
                ? null
                : Timestamp.valueOf(source);
    }
}