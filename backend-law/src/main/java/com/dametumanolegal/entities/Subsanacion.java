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
@Table(name = "subsanacion")
public class Subsanacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    private int plazoEnDias;
    private String fechaInicio;
    private String fechaLimite;
    private String descripcion;

    @OneToMany(mappedBy = "fkSubsanacion")
    private List<Tramite> listaTramite;

}
