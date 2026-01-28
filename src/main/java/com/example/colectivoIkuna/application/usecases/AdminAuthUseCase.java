package com.example.colectivoIkuna.application.usecases;

import com.example.colectivoIkuna.domain.model.AdminUser;
import com.example.colectivoIkuna.domain.port.out.AdminUserRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AdminAuthUseCase {

  private final AdminUserRepositoryPort adminRepo;

  public AdminUser authenticate(String username, String password) {
    AdminUser admin = adminRepo.findByUsername(username)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    // En producción usa BCrypt
    if (!admin.getPassword().equals(password)) {
      throw new RuntimeException("Contraseña incorrecta");
    }
    return admin;
  }

  // Método auxiliar para crear el primer admin si no existe
  public void createInitialAdmin() {
    if(adminRepo.findByUsername("admin").isEmpty()){
      AdminUser admin = new AdminUser();
      admin.setUsername("admin");
      admin.setPassword("ikuna2024");
      admin.setFullName("Super Admin");
      admin.setRole("superadmin");
      admin.setEmail("admin@ikuna.com");
      adminRepo.save(admin);
    }
  }
}