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
@Table(name = "actuado")
public class Actuado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String tipo; // Tipo de actuado (e.g., demanda, resolución, notificación)
    private String descripcion; // Descripción detallada del actuado
    private String fechaCreacion; // Fecha en que se creó el actuado
    private String creador; // Persona o entidad que creó el actuado
    private String contenido; // Contenido del actuado (puede ser el texto del documento)


    @ManyToOne
    private Caso fkCaso;
}
