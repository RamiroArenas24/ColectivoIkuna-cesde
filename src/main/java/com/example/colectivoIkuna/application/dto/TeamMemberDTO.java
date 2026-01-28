package com.example.colectivoIkuna.application.dto;

import lombok.Data;

@Data
public class TeamMemberDTO {
  private Long id;
  private String name;
  private String email;
  private String role;
}