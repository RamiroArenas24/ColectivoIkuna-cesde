package com.example.colectivoIkuna.application.mapper;

import com.example.colectivoIkuna.application.dto.CulturalProjectDTO;
import com.example.colectivoIkuna.domain.model.CulturalProject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;

// 'uses' le dice a MapStruct que use los otros mappers para las listas de tareas y miembros
@Mapper(componentModel = "spring", uses = {TaskMapper.class, TeamMemberMapper.class})
public interface CulturalProjectMapper {

  // --- DE ENTIDAD A DTO ---
  @Mapping(source = "executionDate", target = "date", qualifiedByName = "dateToString")
  @Mapping(source = "coverImageUrl", target = "imageUrl")
  CulturalProjectDTO toDTO(CulturalProject entity);

  // --- DE DTO A ENTIDAD ---
  @Mapping(source = "date", target = "executionDate", qualifiedByName = "stringToDate")
  @Mapping(source = "imageUrl", target = "coverImageUrl")
  CulturalProject toEntity(CulturalProjectDTO dto);

  // Métodos default para lógica personalizada (fechas)
  @Named("dateToString")
  default String dateToString(LocalDate date) {
    return date != null ? date.toString() : null;
  }

  @Named("stringToDate")
  default LocalDate stringToDate(String date) {
    return (date != null && !date.isBlank()) ? LocalDate.parse(date) : null;
  }
}
