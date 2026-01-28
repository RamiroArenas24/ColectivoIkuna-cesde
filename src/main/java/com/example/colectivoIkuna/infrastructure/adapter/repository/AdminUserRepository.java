package com.example.colectivoIkuna.infrastructure.adapter.repository;

import com.example.colectivoIkuna.domain.model.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {
  Optional<AdminUser> findByUsername(String username);
}