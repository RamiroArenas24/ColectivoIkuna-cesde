package com.example.colectivoIkuna.infrastructure.adapter.input.rest;

import com.example.colectivoIkuna.application.dto.request.UserRequestDTO;
import com.example.colectivoIkuna.application.dto.response.UserResponseDTO;
import com.example.colectivoIkuna.application.mapper.AdminUserMapper;
import com.example.colectivoIkuna.application.usecases.UserManagementUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin/users")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class UserManagementController {

  private final UserManagementUseCase userUseCase;
  private final AdminUserMapper userMapper;

  // CORRECCIÓN: Devuelve List<UserResponseDTO>
  @GetMapping("/pending")
  public List<UserResponseDTO> getPending() {
    return userUseCase.getPendingUsers().stream()
        .map(userMapper::toDTO)
        .collect(Collectors.toList());
  }

  // CORRECCIÓN: Devuelve List<UserResponseDTO>
  @GetMapping("/active")
  public List<UserResponseDTO> getActive() {
    return userUseCase.getActiveUsers().stream()
        .map(userMapper::toDTO)
        .collect(Collectors.toList());
  }

  // Este ya estaba bien (UserResponseDTO), ahora compilará porque el mapper ya devuelve ese tipo
  @PostMapping("/register")
  public UserResponseDTO register(@Valid @RequestBody UserRequestDTO requestDto) {
    var entity = userMapper.toEntity(requestDto);
    var saved = userUseCase.registerRequest(entity);
    return userMapper.toDTO(saved);
  }

  // CORRECCIÓN: Devuelve UserResponseDTO
  @PatchMapping("/{id}/approve")
  public UserResponseDTO approve(@PathVariable Long id) {
    return userMapper.toDTO(userUseCase.approveUser(id));
  }

  @DeleteMapping("/{id}/reject")
  public void reject(@PathVariable Long id) {
    userUseCase.rejectUser(id);
  }

}
