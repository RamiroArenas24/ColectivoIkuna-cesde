package com.example.colectivoIkuna.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "ikuna_calendario_eventos")
@Data
public class EventCalendar {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "IdEvento")
    private Long id;

    @Column(name = "NombreActividad", nullable = false)
    private String nombreActividad;
    @Column(name = "FechaHora")
    private LocalDateTime fechaHora;
    @Column(name = "AvancePorcentaje")
    private Double avancePorcentaje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdProyecto")
    private CulturalProject proyecto;

}


