package com.dametumanolegal.infrastructure.persistence.entities;

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
@Table(name = "cita")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String fechaCita;
    private int duracion; // Duración en minutos
    private String motivo;
    private String ubicacion;
    private String estado;
    private String notas;
    private String fechaCreacion;
    private String creador;


    @ManyToOne
    private Secretaria fkSecre;
    @ManyToOne
    private Cliente fkCliente;
}
