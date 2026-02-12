package com.example.colectivoIkuna.application.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class BudgetDTO {

    private Long BudgetId;
    private BigDecimal amount;
    private BigDecimal totalIncome;
    private BigDecimal totalExpense;
    private BigDecimal balance;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long projectId;
}
