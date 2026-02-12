package com.example.colectivoIkuna.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "budgets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

     /* conexión mediante clave foranea PROJECTID
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;
     */

    @Column(nullable = false)
    private BigDecimal amount;

    private BigDecimal totalIncome;
    private BigDecimal totalExpense;
    private BigDecimal balance;

    private LocalDate startDate;
    private LocalDate endDate;


    //Actualización del balance automáticamente
    @PrePersist
    @PreUpdate
    public void calculateBalance() {
        if (this.totalIncome == null) this.totalIncome = BigDecimal.ZERO;
        if (this.totalExpense == null) this.totalExpense = BigDecimal.ZERO;
        if (this.amount == null) this.amount = BigDecimal.ZERO;

        this.balance = this.amount.add(this.totalIncome).add(this.totalExpense);
    }

}
