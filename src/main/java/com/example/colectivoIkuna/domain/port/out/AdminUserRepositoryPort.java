package com.example.colectivoIkuna.domain.port.out;

import com.example.colectivoIkuna.domain.model.AdminUser;
import java.util.Optional;

public interface AdminUserRepositoryPort {
  Optional<AdminUser> findByUsername(String username);
  AdminUser save(AdminUser user);
}