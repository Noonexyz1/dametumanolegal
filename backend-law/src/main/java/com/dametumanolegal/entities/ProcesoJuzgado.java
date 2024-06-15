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
@Table(name = "procesoJuzgado")
public class ProcesoJuzgado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @ManyToOne
    private CasoJuzgado fkCasoJuzgado;

    @ManyToOne
    private Notificacion fkNotificacion;

    @ManyToOne
    private Juez fkJuez;
}
