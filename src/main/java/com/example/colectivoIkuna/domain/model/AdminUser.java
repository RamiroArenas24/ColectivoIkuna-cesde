package com.example.colectivoIkuna.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ikuna_admins")
@Data
public class AdminUser {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String username;
  private String password;
  private String fullName;
  private String role;
  private String email;
}