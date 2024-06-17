package com.dametumanolegal.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CuadernoRequest {
    private String numero;
    private String titulo;
    private String descripcion;
    private String fechaCreacion;
    private String fechaUltimaActualizacion;
    private String estado;
    private String responsable;
    private String observaciones;
    private String tipoCuaderno;
}
