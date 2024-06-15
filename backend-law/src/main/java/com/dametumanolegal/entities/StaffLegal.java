package com.dametumanolegal.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stafflegal")
public class StaffLegal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;


    @ManyToOne
    private FiguraLegal fkFigLegal;


    @OneToMany(mappedBy = "fkStaffLegal")
    private List<Abogado> listaAbogados;
    @OneToMany(mappedBy = "fkStaffLegal")
    private List<Cliente> listaClientes;
    @OneToMany(mappedBy = "fkStaffLegal")
    private List<Procurador> listaProcuradores;
    @OneToMany(mappedBy = "fkStaffLegal")
    private List<Secretaria> listaSecretarias;


    @OneToMany(mappedBy = "fkStaffLegal")
    private List<Cuenta> listaCuentas;
    @OneToMany(mappedBy = "fkStaffLegal")
    private List<Sesion> listaSesiones;
}
