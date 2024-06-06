package com.dametumanolegal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cuenta")
public class Cuenta {
    @Id
    @SequenceGenerator(
            name = "cuenta_sequence",
            sequenceName = "cuenta_sequence",
            allocationSize = 1,
            initialValue = 1999
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cuenta_sequence"
    )
    @Column(
            updatable = false
    )
    private Long idUsuario;
    private String ciUsuario;
    private String passUsuario;
    private boolean isActive;




    @ManyToOne
    private StaffLegal idStaffLegal;
}