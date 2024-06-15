package com.dametumanolegal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "procesoFiscal")
public class ProcesoFiscal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @ManyToOne
    private CasoFiscalia fkCasoFiscal;

    @ManyToOne
    private Investigador fkInvestigador;

    @ManyToOne
    private Fiscal fkFiscal;

    @ManyToOne
    private Cuaderno fkCuaderno;

    @ManyToOne
    private Ito fkIto;

    @ManyToOne
    private Notificacion fkNotificacion;

}
