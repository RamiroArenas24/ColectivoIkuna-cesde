package com.example.colectivoIkuna.infrastructure.adapter.input.rest;

import com.example.colectivoIkuna.application.dto.request.CulturalProjectDTO;
import com.example.colectivoIkuna.application.mapper.CulturalProjectMapper;
import com.example.colectivoIkuna.application.usecases.IkunaManagerUseCase;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ikuna")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Agregado para evitar problemas de CORS con React
public class IkunaDashboardController {

  private final IkunaManagerUseCase ikunaManager;
  private final CulturalProjectMapper projectMapper; // Spring inyectará la implementación generada

  @GetMapping("/portfolio")
  public List<CulturalProjectDTO> getPortfolio() {
    return ikunaManager.getPortfolio().stream()
        .map(projectMapper::toDTO)
        .collect(Collectors.toList());
  }

  @PostMapping("/projects")
  public CulturalProjectDTO createProject(@Valid @RequestBody CulturalProjectDTO dto) {
    var entity = projectMapper.toEntity(dto);
    var saved = ikunaManager.launchOrUpdateProject(entity);
    return projectMapper.toDTO(saved);
  }

  @PutMapping("/projects/{id}")
  public CulturalProjectDTO updateProject(@PathVariable Long id,@Valid @RequestBody CulturalProjectDTO dto) {
    dto.setId(id);
    var entity = projectMapper.toEntity(dto);
    var saved = ikunaManager.launchOrUpdateProject(entity);
    return projectMapper.toDTO(saved);
  }
}