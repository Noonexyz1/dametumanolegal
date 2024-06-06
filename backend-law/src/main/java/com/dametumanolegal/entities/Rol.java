package com.dametumanolegal.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @SequenceGenerator(
            name = "rol_sequence",
            sequenceName = "rol_sequence",
            allocationSize = 1,
            initialValue = 1999
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rol_sequence"
    )
    @Column(
            updatable = false
    )
    private Long idRol;
    private String nombreRol;
    private String descripcionRol;
    private boolean isActive;




    @OneToMany(mappedBy = "idRol")
    private List<Asignacion> listaAsginaciones;
}
