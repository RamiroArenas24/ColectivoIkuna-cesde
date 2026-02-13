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
    private String specificRole; // Ej: "Muralista,"Tallerista", "Organizador de eventos", etc.
        @Column(name = "fechaInicioParticipacion")
    private LocalDate initialParticipationDate;

    @ManyToOne
    @JoinColumn(name = "IdProyecto")
    private CulturalProject culturalProject;

    @ManyToOne
    @JoinColumn(name = "IdUsuario")
    private TeamMember collaborator;
}
