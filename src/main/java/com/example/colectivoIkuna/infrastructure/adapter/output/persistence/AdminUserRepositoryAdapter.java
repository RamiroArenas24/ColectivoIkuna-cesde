package com.example.colectivoIkuna.infrastructure.adapter.output.persistence;

import com.example.colectivoIkuna.domain.model.IkunaUser;
import com.example.colectivoIkuna.domain.port.out.AdminUserRepositoryPort;
import com.example.colectivoIkuna.infrastructure.adapter.repository.AdminUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AdminUserRepositoryAdapter implements AdminUserRepositoryPort {

  private final AdminUserRepository jpaRepository;

  @Override
  public Optional<IkunaUser> findByUsername(String username) {
    return jpaRepository.findByUsername(username);
  }

  @Override
  public Optional<IkunaUser> findById(Long id) {
    return Optional.empty();
  }

  @Override
  public IkunaUser save(IkunaUser user) {
    return jpaRepository.save(user);
  }

  @Override
  public List<IkunaUser> findByStatus(String status) {
    return List.of();
  }

  @Override
  public void deleteById(Long id) {

  }
}