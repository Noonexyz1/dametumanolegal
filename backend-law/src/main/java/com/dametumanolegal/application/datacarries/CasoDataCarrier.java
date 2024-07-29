package com.dametumanolegal.application.datacarries;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CasoDataCarrier {
    private Long id;
    private String titulo;
    private String descripcion;
    private String fechaInicio;
    private String fechaCierre;
    private String estado;
    private String tipoCaso;
    private String responsable;
    private String observaciones;


    private HonorarioDataCarrier fkHonor;


    private ClienteDataCarrier fkCliente;
    private AbogadoDataCarrier fkAbogado;
    private ProcuradorDataCarrier fkProcurador;

}
