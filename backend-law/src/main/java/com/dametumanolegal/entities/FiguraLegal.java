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
@Table(name = "figuralegal")
public class FiguraLegal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String nombres;
    private String apellidos;
    private String ci;
    private boolean isActive;

    @OneToMany(mappedBy = "fkFigLegal")
    private List<StaffLegal> listaStafLegal;
    @OneToMany(mappedBy = "fkFigLegal")
    private List<Fiscal> listaFiscales;
    @OneToMany(mappedBy = "fkFigLegal")
    private List<Investigador> listaInvestigadores;
    @OneToMany(mappedBy = "fkFigLegal")
    private List<Juez> listaJueces;
}
