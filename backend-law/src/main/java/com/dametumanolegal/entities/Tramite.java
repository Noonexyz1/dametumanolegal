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
@Table(name = "tramite")
public class Tramite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    private boolean estado;
    private int duraMeses;
    private int numEtapas;
    private String instancia;

    @ManyToOne
    private Cliente fkCliente;
    @ManyToOne
    private Abogado fkAbogado;
    @ManyToOne
    private Honorario fkHonor;
    @ManyToOne
    private Subsanacion fkSubsanacion;

    @OneToMany(mappedBy = "fkTramite")
    private List<ArchivoTramite> listaArchivoTramite;
}
