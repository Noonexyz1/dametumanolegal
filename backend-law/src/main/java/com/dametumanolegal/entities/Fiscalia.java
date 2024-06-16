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
@Table(name = "fiscalia")
public class Fiscalia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String ciudad;
    private String departamento;
    private String pais;
    private String tipo;

    @OneToMany(mappedBy = "fkFiscalia")
    private List<Fiscal> listaFiscales;

    @OneToMany(mappedBy = "fkFiscalia")
    private List<Investigador> listaInvestigadores;

}
