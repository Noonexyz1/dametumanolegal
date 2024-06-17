package com.dametumanolegal.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CasoResponse {
    private Long id;
    private String titulo;
    private String descripcion;
    private String fechaInicio;
    private String fechaCierre;
    private String estado;
    private String tipoCaso;
    private String responsable;
    private String observaciones;


    private HonorarioResponse fkHonor;
    private ClienteResponse fkCliente;
    private AbogadoResponse fkAbogado;
    private ProcuradorResponse fkProcurador;
}
