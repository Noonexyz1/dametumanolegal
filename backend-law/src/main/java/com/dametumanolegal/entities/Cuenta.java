package com.dametumanolegal.entities;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String ciUsuario;
    private String passUsuario;
    private boolean isActive;




    @ManyToOne
    private StaffLegal fkStaffLegal;
}
