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
    @SequenceGenerator(
            name = "stafflegal_sequence",
            sequenceName = "stafflegal_sequence",
            allocationSize = 1,
            initialValue = 0
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "stafflegal_sequence"
    )
    @Column(
            updatable = false
    )
    private Long id;
    private String nombres;
    private String apellidos;
    private String ci;
    private boolean isActive;




    @OneToMany(mappedBy = "idStaffLegal")
    private List<Abogado> listaAbogados;
    @OneToMany(mappedBy = "idStaffLegal")
    private List<Cuenta> listaCuentas;
    @OneToMany(mappedBy = "idStaffLegal")
    private List<Sesion> listaSesiones;
    @OneToMany(mappedBy = "idStaffLegal")
    private List<Asignacion> listaAsginaciones;
}
