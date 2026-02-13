package com.example.colectivoIkuna.application.mapper;

import com.example.colectivoIkuna.application.dto.ProjectCollaborationDTO;
import com.example.colectivoIkuna.domain.model.ProjectCollaboration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CollaborationMapper {

    // --- DE ENTIDAD A DTO ---
    @Mapping(source = "collaborator.id", target = "collaboratorId")
    @Mapping(source = "collaborator.name", target = "collaboratorName")
    @Mapping(source = "initialParticipationDate", target = "startDate")
    @Mapping(source = "specificRole", target = "role")
    ProjectCollaborationDTO toDTO(ProjectCollaboration entity);

    // --- DE DTO A ENTIDAD ---
    @Mapping(source = "collaboratorId", target = "collaborator.id")
    @Mapping(source = "startDate", target = "initialParticipationDate")
    @Mapping(source = "role", target = "specificRole")
    ProjectCollaboration toEntity(ProjectCollaborationDTO dto);
}