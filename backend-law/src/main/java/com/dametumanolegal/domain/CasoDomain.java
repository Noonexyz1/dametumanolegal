package com.dametumanolegal.domain;

import com.dametumanolegal.entities.*;
import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CasoDomain {
    private Long id;
    private String titulo;
    private String descripcion;
    private String fechaInicio;
    private String fechaCierre;
    private String estado;
    private String tipoCaso;
    private String responsable;
    private String observaciones;


    private HonorarioDomain fkHonor;


    private ClienteDomain fkCliente;
    private AbogadoDomain fkAbogado;
    private ProcuradorDomain fkProcurador;

}
