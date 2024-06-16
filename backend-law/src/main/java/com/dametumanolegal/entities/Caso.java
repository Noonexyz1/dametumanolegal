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
@Table(name = "caso")
public class Caso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String titulo;
    private String descripcion;
    private String fechaInicio;
    private String fechaCierre;
    private String estado;
    private String tipoCaso;
    private String responsable;
    private String observaciones;



    @OneToMany(mappedBy = "fkCaso")
    private List<ArchivoCaso> listaArchivoCasos;
    @OneToMany(mappedBy = "fkCaso")
    private List<Memorial> listaMemoriales;

    @ManyToOne
    private Honorario fkHonor;

    @OneToMany(mappedBy = "fkCaso")
    private List<CasoJuzgado> listaCasosJuzgados;
    @OneToMany(mappedBy = "fkCaso")
    private List<Actuado> listaActuados;

    @ManyToOne
    private Cliente fkCliente;
    @ManyToOne
    private Abogado fkAbogado;
    @ManyToOne
    private Procurador fkProcurador;

    @OneToMany(mappedBy = "fkCaso")
    private List<CasoJuzgado> listaCasosJuzgado;
    @OneToMany(mappedBy = "fkCaso")
    private List<CasoFiscalia> listaCasosFiscalia;
}