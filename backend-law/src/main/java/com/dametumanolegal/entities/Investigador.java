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
@Table(name = "investigador")
public class Investigador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @ManyToOne
    private FiguraLegal fkFigLegal;

    @OneToMany(mappedBy = "fkInvestigador")
    private List<ProcesoFiscal> listaProcesosFiscal;

    @ManyToOne
    private Fiscalia fkFiscalia;
}
