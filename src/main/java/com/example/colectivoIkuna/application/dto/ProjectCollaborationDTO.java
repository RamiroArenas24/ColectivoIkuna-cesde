package com.example.colectivoIkuna.application.dto;

import lombok.Data;

@Data
public class ProjectCollaborationDTO {
    private long id;
    private String specificRole;
    private String initialParticipationDate;
    private Long collaboratorId;
    private String collaboratorName;
}
