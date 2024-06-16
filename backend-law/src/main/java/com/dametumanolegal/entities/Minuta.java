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
@Table(name = "minuta")
public class Minuta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String fecha; // Fecha de la minuta
    private String descripcion; // Descripción de los servicios prestados
    private int horasFacturadas; // Horas facturadas en la minuta
    private double costoHora; // Costo por hora del servicio
    private double total; // Total facturado en la minuta


    @ManyToOne
    private Cliente fkCliente;
    @ManyToOne
    private Abogado fkAbogado;
}
