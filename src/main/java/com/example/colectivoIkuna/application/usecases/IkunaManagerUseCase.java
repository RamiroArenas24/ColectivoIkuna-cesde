package com.example.colectivoIkuna.application.usecases;

import com.example.colectivoIkuna.domain.model.CulturalProject;
import com.example.colectivoIkuna.domain.port.out.CulturalProjectRepositoryPort;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
public class IkunaManagerUseCase {

  private final CulturalProjectRepositoryPort projectRepo;

  public List<CulturalProject> getPortfolio() {
    return projectRepo.findAll();
  }

  public CulturalProject launchOrUpdateProject(CulturalProject project) {
    if (project.getProgress() == null) {
      project.setProgress(0);
    }
    return projectRepo.save(project);
  }
}