package com.example.colectivoIkuna.application.dto.request;

import lombok.Data;
import java.util.List;

@Data
public class CulturalProjectDTO {
  private Long id;
  private String title;
  private String status;
  private String date; // String para React
  private Integer progress;
  private String category;
  private String description;
  private String imageUrl;

  private List<TeamMemberDTO> teamMembers;
  private List<TaskDTO> tasks;
}