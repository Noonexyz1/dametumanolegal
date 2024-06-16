package com.dametumanolegal.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MinutaDomain {
    private Long id;
    private String fecha; // Fecha de la minuta
    private String descripcion; // Descripción de los servicios prestados
    private int horasFacturadas; // Horas facturadas en la minuta
    private double costoHora; // Costo por hora del servicio
    private double total; // Total facturado en la minuta

    private ClienteDomain fkCliente;
    private AbogadoDomain fkAbogado;
}
