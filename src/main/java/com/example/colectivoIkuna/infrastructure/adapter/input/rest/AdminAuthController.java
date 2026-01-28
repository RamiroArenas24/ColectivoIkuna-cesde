package com.example.colectivoIkuna.infrastructure.adapter.input.rest;

import com.example.colectivoIkuna.application.dto.LoginRequestDTO;
import com.example.colectivoIkuna.application.usecases.AdminAuthUseCase;
import com.example.colectivoIkuna.domain.model.AdminUser;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class AdminAuthController {

  private final AdminAuthUseCase authUseCase;

  @PostMapping("/login")
  public AdminUser login(@RequestBody LoginRequestDTO request) {
    return authUseCase.authenticate(request.getUsername(), request.getPassword());
  }

  // Endpoint auxiliar para crear el primer admin si está vacía la BD
  @PostMapping("/init")
  public String init() {
    authUseCase.createInitialAdmin();
    return "Admin inicial creado (si no existía)";
  }
}