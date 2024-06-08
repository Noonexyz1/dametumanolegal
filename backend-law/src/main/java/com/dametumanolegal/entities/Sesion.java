package com.dametumanolegal.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sesion")
public class Sesion {
    /*@Id
    @SequenceGenerator(
            name = "sesion_sequence",
            sequenceName = "sesion_sequence",
            allocationSize = 1,
            initialValue = 2999
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sesion_sequence"
    )
    @Column(
            updatable = false
    )*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long idSesion;
    private String fechaSesion;
    private boolean estadoSesion;




    @ManyToOne
    private StaffLegal fk;
}
