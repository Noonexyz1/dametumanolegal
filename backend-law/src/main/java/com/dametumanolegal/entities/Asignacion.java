package com.dametumanolegal.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "asignacion")
public class Asignacion {
    /*@Id
    @SequenceGenerator(
            name = "asignacion_sequence",
            sequenceName = "asignacion_sequence",
            allocationSize = 1,
            initialValue = 999
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "asignacion_sequence"
    )
    @Column(
            updatable = false
    )*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long idAsignacion;
    private String fechaAsignacion;
    private String fechaSustraccion;
    private boolean isActive;




    @ManyToOne
    private StaffLegal idStaffLegal;
    @ManyToOne
    private Rol idRol;
}
