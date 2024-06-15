package com.dametumanolegal.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "abogado")
public class Abogado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    private boolean isAdmin;




    @ManyToOne
    private StaffLegal fkStaffLegal;

    @OneToMany(mappedBy = "fkAbogado")
    private List<Caso> listaCasos;
}
