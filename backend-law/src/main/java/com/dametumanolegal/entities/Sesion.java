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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String fechaSesion;
    private boolean estadoSesion;




    @ManyToOne
    private StaffLegal fkStaffLegal;
}
