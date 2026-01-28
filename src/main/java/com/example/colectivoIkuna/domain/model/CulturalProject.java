package com.example.colectivoIkuna.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ikuna_projects")
@Data
public class CulturalProject {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String category; // 'Espacios', 'Eventos', etc.
  private String status;   // 'completed', 'in-progress'
  private Integer progress;
  private LocalDate executionDate; // En BD es fecha real

  @Column(columnDefinition = "TEXT")
  private String description;
  private String coverImageUrl;

  // Relaciones: Un proyecto tiene muchos miembros y tareas
  // CascadeType.ALL significa que si guardas el proyecto, se guardan las tareas automáticamente
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "project_id")
  private List<TeamMember> teamMembers = new ArrayList<>();

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "project_id")
  private List<Task> tasks = new ArrayList<>();
}