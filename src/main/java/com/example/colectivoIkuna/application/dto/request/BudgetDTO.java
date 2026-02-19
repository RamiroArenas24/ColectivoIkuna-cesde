package com.example.colectivoIkuna.application.dto.request;

import com.example.colectivoIkuna.domain.model.BudgetStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class BudgetDTO {

    private Long budgetId;
    private BigDecimal amount;
    private BigDecimal totalIncome;
    private BigDecimal totalExpense;
    private BigDecimal balance;
    private LocalDate startDate;
    private LocalDate endDate;
    private BudgetStatus status;

    @JsonProperty("projectId")
    private Long projectId;
}
