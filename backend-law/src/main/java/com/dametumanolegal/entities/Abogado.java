package com.dametumanolegal.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "abogado")
public class Abogado {
    /*@Id
    @SequenceGenerator(
            name = "abogado_sequence",
            sequenceName = "abogado_sequence",
            allocationSize = 1,
            initialValue = 999
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "abogado_sequence"
    )
    @Column(
            updatable = false
    )*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long idAbogado;
    private boolean isAdmin;




    @ManyToOne
    private StaffLegal idStaffLegal;
}
