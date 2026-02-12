package com.example.colectivoIkuna.domain.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "ikuna_colaboracion_proyectos")
@Data
public class ProjectCollaboration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdColaboracion")
    private Long id;

    @Column(name = "RolEspecifico")
    private String rolEspecifico; // Ej: "Muralista,"Tallerista", "Organizador de eventos", etc.
        @Column(name = "fechaInicioParticipacion")
    private LocalDate fechaInicioParticipacion;

    @ManyToOne
    @JoinColumn(name = "IdProyecto")
    private CulturalProject proyecto;

    @ManyToOne
    @JoinColumn(name = "IdUsuario")
    private TeamMember colaborador;
}
