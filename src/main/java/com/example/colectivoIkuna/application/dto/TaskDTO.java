package com.example.colectivoIkuna.application.dto;

import lombok.Data;

@Data
public class TaskDTO {
  private Long id;
  private String title;
  private String assignedTo;
  private String startDate;
  private String endDate;
  private String status;
}