package com.example.colectivoIkuna.application.usecases;

import com.example.colectivoIkuna.domain.model.CulturalProject;
import com.example.colectivoIkuna.domain.model.IkunaUser;
import com.example.colectivoIkuna.domain.port.out.IkunaUserRepositoryPort;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
public class UserManagementUseCase {

  private final IkunaUserRepositoryPort userRepo;

  public List<IkunaUser> getPendingUsers() {
    return userRepo.findByStatus("PENDING");
  }

  public List<IkunaUser> getActiveUsers() {
    return userRepo.findByStatus("ACTIVE");
  }

  public void createSuperAdmin() {
    IkunaUser admin = new IkunaUser();
    admin.setUsername("admin");
    admin.setRole("SUPER_ADMIN"); // <--- Aquí definimos que es el jefe
    admin.setStatus("ACTIVE");
    userRepo.save(admin);
  }

  public IkunaUser registerRequest(IkunaUser user) {
    if (userRepo.findByUsername(user.getUsername()).isPresent()) {
      throw new IllegalArgumentException("El usuario '" + user.getUsername() + "' ya existe.");
    }

    if (user.getRole() == null || user.getRole().isEmpty()) {
      user.setRole("COLLABORATOR");
    }

    if (user.getStatus() == null || user.getStatus().isEmpty()) {
      user.setStatus("PENDING");
    }

    user.setRequestDate(java.time.LocalDate.now());

    return userRepo.save(user);
  }

  public IkunaUser approveUser(Long userId) {
    IkunaUser user = userRepo.findById(userId)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    user.setStatus("ACTIVE");
    return userRepo.save(user);
  }

  public void rejectUser(Long userId) {
    if (!userRepo.findById(userId).isPresent()) {
      throw new RuntimeException("No se puede rechazar, el usuario no existe.");
    }
    userRepo.deleteById(userId);
  }

  public CulturalProject launchOrUpdateProject(CulturalProject project) {
    // VALIDACIÓN 1: Fechas coherentes
    if (project.getExecutionDate() != null && project.getExecutionDate().isBefore(java.time.LocalDate.now())) {
      // Opcional: permitir fechas pasadas solo si es carga histórica
      // throw new IllegalArgumentException("La fecha del proyecto no puede ser en el pasado");
    }

    // VALIDACIÓN 2: Título obligatorio
    if (project.getTitle() == null || project.getTitle().isEmpty()) {
      throw new IllegalArgumentException("El proyecto debe tener un título.");
    }

    return project;
  }

}
