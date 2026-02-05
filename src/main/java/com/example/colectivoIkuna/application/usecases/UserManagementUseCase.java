package com.example.colectivoIkuna.application.usecases;

import com.example.colectivoIkuna.domain.model.IkunaUser;
import com.example.colectivoIkuna.domain.port.out.AdminUserRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class UserManagementUseCase {

  private final AdminUserRepositoryPort userRepo;

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
    user.setRole("COLLABORATOR"); // Por defecto entra con rol bajo
    user.setStatus("PENDING");    // Por defecto entra esperando aprobación
    user.setRequestDate(LocalDate.now());
    return userRepo.save(user);
  }

  public IkunaUser approveUser(Long userId) {
    IkunaUser user = userRepo.findById(userId)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    user.setStatus("ACTIVE");
    return userRepo.save(user);
  }

  public void rejectUser(Long userId) {
    userRepo.deleteById(userId);
  }

}
