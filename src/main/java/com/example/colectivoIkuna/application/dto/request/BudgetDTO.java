package com.example.colectivoIkuna.application.dto.request;

import com.example.colectivoIkuna.domain.model.BudgetStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class BudgetDTO {

    private Long budgetId;

    @NotBlank(message = "Debe existir un monto asignado")
    @Pattern(regexp = "^(0|[1-9]\\d*)(\\.\\d{1,2})?$",
            message = "El monto debe ser un número válido con máximo 2 decimales")
    private BigDecimal amount;

    @Pattern(regexp = "^(0|[1-9]\\d*)(\\.\\d{1,2})?$",
            message = "totalIncome debe ser un número válido con máximo 2 decimales")
    private BigDecimal totalIncome;

    @Pattern(regexp = "^(0|[1-9]\\d*)(\\.\\d{1,2})?$",
            message = "totalExpense debe ser un número válido con máximo 2 decimales")
    private BigDecimal totalExpense;

    @Pattern(regexp = "^-?(0|[1-9]\\d*)(\\.\\d{1,2})?$",
            message = "balance debe ser un número válido")
    private BigDecimal balance;

    @NotBlank(message = "La fecha de inicio es obligatoria")
    @Pattern(regexp = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$",
            message = "La fecha debe tener el formato AAAA-MM-DD")
    private LocalDate startDate;

    private LocalDate endDate;
    private BudgetStatus status;

    @NotBlank(message = "El ID del proyecto es obligatorio")
    @JsonProperty("projectId")
    private Long projectId;
}
