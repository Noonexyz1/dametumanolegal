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
@Table(name = "cuaderno")
public class Cuaderno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String numero;
    private String titulo;
    private String descripcion;
    private String fechaCreacion;
    private String fechaUltimaActualizacion;
    private String estado;
    private String responsable;
    private String observaciones;
    private String tipoCuaderno;

    @OneToMany(mappedBy = "fkCuaderno")
    private List<ProcesoFiscal> listaProcesosFiscal;
}
