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
@Table(name = "ito")
public class Ito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String denunciante;
    private String abogadoDenunciante;
    private String denunciado;
    private String abogadoDenunciado;
    private String fiscal;
    private String investigador;
    private String descripcionHechos;
    private String fechaInicio;
    private String fechaFin;


    @OneToMany(mappedBy = "fkIto")
    private List<ProcesoFiscal> listaProcesosFiscal;
}
