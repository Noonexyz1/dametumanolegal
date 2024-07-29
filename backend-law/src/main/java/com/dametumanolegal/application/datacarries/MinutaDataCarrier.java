package com.dametumanolegal.application.datacarries;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MinutaDataCarrier {
    private Long id;
    private String fecha; // Fecha de la minuta
    private String descripcion; // Descripción de los servicios prestados
    private int horasFacturadas; // Horas facturadas en la minuta
    private double costoHora; // Costo por hora del servicio
    private double total; // Total facturado en la minuta

    private ClienteDataCarrier fkCliente;
    private AbogadoDataCarrier fkAbogado;
}
