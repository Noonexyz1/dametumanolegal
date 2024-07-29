package com.dametumanolegal.application.datacarries;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FiscaliaDataCarrier {
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String ciudad;
    private String departamento;
    private String pais;
    private String tipo;

}
