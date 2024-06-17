package com.dametumanolegal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "honorario")
public class Honorario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String tipoServicio;
    private String descripcion;
    private Double monto;
    private String moneda;


    @OneToMany(mappedBy = "fkHonor")
    private List<Caso> listaCasos;

    @OneToMany(mappedBy = "fkHonor")
    private List<Tramite> listaTramites;
}
