package com.example.colectivoIkuna.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

@Entity
@Table(name = "Proyecto")
@Data
public class CulturalProject {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IdProyecto")
  private Long id;

  @Column(name = "TituloProyecto")
  private String title;
  @Column(name = "LineaTrabajoCultural")
  private String category;
  @Column(name = "EstadoProyecto")
  private String status;
  @Column(name = "ProgresoEjecucionProyecto")
  private Integer progress;
  @Column(name = "FechaInicioProyecto")
  private LocalDate executionDate;
  @Column(name = "MontoInicial")
  private BigDecimal totalBudget;
    @Column(name = "MontoEjecutado")
  private BigDecimal executedBudget;


  @Column(name = "DescripcionProyecto", columnDefinition = "TEXT")
  private String description;
  @Column(name = "ImagenReferencia")
  private String coverImageUrl;

  // Relaciones: Un proyecto tiene muchos miembros y tareas
  // CascadeType.ALL significa que si guardas el proyecto, se guardan las tareas automáticamente
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "IdProyecto")
  private List<TeamMember> teamMembers = new ArrayList<>();

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "IdProyecto")
  private List<Task> tasks = new ArrayList<>();

  @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<EventCalendar> eventCalendars = new ArrayList<>();

  @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<ProjectCollaboration> colaboradores = new ArrayList<>();
}