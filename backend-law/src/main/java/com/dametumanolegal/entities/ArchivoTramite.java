package com.dametumanolegal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "archivoTramite")
public class ArchivoTramite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String numeroTramite; // Número de identificación del caso
    private String descripcion; // Descripción del caso
    private String direccionFisica; // Dirección física donde se guarda el archivo (e.g., vagón, estante)
    private String fechaCreacion; // Fecha de creación del archivo del caso
    private String responsable; // Persona responsable del archivo del caso


    @ManyToOne
    private Documentacion fkDocu;
    @ManyToOne
    private Tramite fkTramite;
}
