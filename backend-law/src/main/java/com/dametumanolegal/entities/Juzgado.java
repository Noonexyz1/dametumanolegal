package com.dametumanolegal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "juzgado")
public class Juzgado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String ciudad;
    private String departamento;
    private String pais;
    private String tipo;

    @OneToMany(mappedBy = "fkJuzgado")
    private List<Juez> listaJueces;
}
