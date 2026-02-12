package com.example.colectivoIkuna.configuration;

import com.example.colectivoIkuna.application.usecases.AdminAuthUseCase;
import com.example.colectivoIkuna.application.usecases.IkunaManagerUseCase;
import com.example.colectivoIkuna.domain.port.out.AdminUserRepositoryPort;
import com.example.colectivoIkuna.domain.port.out.BudgetRepository;
import com.example.colectivoIkuna.domain.port.out.CulturalProjectRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

  @Bean
  public IkunaManagerUseCase ikunaManager(CulturalProjectRepositoryPort repo) {
    return new IkunaManagerUseCase(repo);
  }

  @Bean
  public AdminAuthUseCase adminAuth(AdminUserRepositoryPort repo) {
    return new AdminAuthUseCase(repo);
  }

  @Bean
    public CreateBudgetUseCase createBudgetUseCase(BudgetRepository budgetRepository, BudgetMapper budgetMapper) {
      return new CreateBudgetUseCase(budgetRepository, budgetMapper);
  }

  @Bean
    public GetProjectBudgetUseCase getProjectBudgetUseCase(BudgetRepository budgetRepository) {
      return new GetProjectBudgetUseCase(budgetRepository);
  }


}