package com.example.colectivoIkuna.application.mapper;

import com.example.colectivoIkuna.application.dto.ProjectCollaborationDTO;
import com.example.colectivoIkuna.domain.model.ProjectCollaboration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CollaborationMapper {

    @Mapping(source = "colaborador.id", target = "colaboradorId")
    @Mapping(source = "colaborador.name", target = "nombreColaborador")
    @Mapping(source = "fechaInicioParticipacion", target = "fechaInicioParticipacion")
    ProjectCollaborationDTO toDTO(ProjectCollaboration entity);

    @Mapping(source = "colaboradorId", target = "colaborador.id")
    @Mapping(source = "fechaInicioParticipacion", target = "fechaInicioParticipacion")
    ProjectCollaboration toEntity(ProjectCollaborationDTO dto);
}