package com.example.colectivoIkuna.application.usecases;

import com.example.colectivoIkuna.domain.model.CulturalProject;
import com.example.colectivoIkuna.domain.port.out.CulturalProjectRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@RequiredArgsConstructor
public class IkunaManagerUseCase {

  private final CulturalProjectRepositoryPort projectRepo;

  public List<CulturalProject> getPortfolio() {
    return projectRepo.findAll();
  }

  public CulturalProject launchOrUpdateProject(CulturalProject project) {
    // 1. Asegurar relación bidireccional y LIMPIAR IDs si es creación
    if (project.getEventCalendars() != null) {
      project.getEventCalendars().forEach(evento -> {
        evento.setProject(project);
        // Si el proyecto es nuevo (id null), los hijos NO deben tener ID
        if (project.getId() == null) {
          evento.setId(null);
        }
      });
    }

    if (project.getColaboradores() != null) {
      project.getColaboradores().forEach(colab -> {
        colab.setCulturalProject(project);
        if (project.getId() == null) {
          colab.setId(null);
        }
      });
    }

    // 2. Lógica de presupuesto (BigDecimal como quedamos)
    if (project.getTotalBudget() != null && project.getTotalBudget().compareTo(BigDecimal.ZERO) > 0) {
      BigDecimal executed = (project.getExecutedBudget() != null) ? project.getExecutedBudget() : BigDecimal.ZERO;
      BigDecimal percentage = executed.multiply(new BigDecimal("100"))
              .divide(project.getTotalBudget(), 2, RoundingMode.HALF_UP);
      project.setProgress(Math.min(100, percentage.intValue()));
    } else if (project.getProgress() == null) {
      project.setProgress(0);
    }

    return projectRepo.save(project);
  }
}