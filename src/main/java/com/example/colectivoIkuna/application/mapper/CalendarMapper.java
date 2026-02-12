package com.example.colectivoIkuna.application.mapper;

import com.example.colectivoIkuna.application.dto.EventCalendarDTO;
import com.example.colectivoIkuna.domain.model.EventCalendar;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface CalendarMapper {

    @Mapping(source = "fechaHora", target = "fechaHora", qualifiedByName = "dateTimeToString")
    EventCalendarDTO toDTO(EventCalendar entity);

    @Mapping(source = "fechaHora", target = "fechaHora", qualifiedByName = "stringToDateTime")
    EventCalendar toEntity(EventCalendarDTO dto);

    @Named("dateTimeToString")
    default String dateTimeToString(LocalDateTime dateTime) {
        return dateTime != null ? dateTime.toString() : null;
    }

    @Named("stringToDateTime")
    default LocalDateTime stringToDateTime(String dateTime) {
        return (dateTime != null && !dateTime.isBlank()) ? LocalDateTime.parse(dateTime) : null;
    }
}