package com.dametumanolegal.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CuadernoDomain {
    private Long id;

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
