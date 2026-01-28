package com.example.colectivoIkuna.infrastructure.adapter.output.persistence;

import com.example.colectivoIkuna.domain.model.AdminUser;
import com.example.colectivoIkuna.domain.port.out.AdminUserRepositoryPort;
import com.example.colectivoIkuna.infrastructure.adapter.repository.AdminUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AdminUserRepositoryAdapter implements AdminUserRepositoryPort {

  private final AdminUserRepository jpaRepository;

  @Override
  public Optional<AdminUser> findByUsername(String username) {
    return jpaRepository.findByUsername(username);
  }

  @Override
  public AdminUser save(AdminUser user) {
    return jpaRepository.save(user);
  }
}