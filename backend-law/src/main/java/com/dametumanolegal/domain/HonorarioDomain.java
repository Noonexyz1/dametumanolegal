package com.dametumanolegal.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HonorarioDomain {
    private Long id;
    private String tipoServicio;
    private String descripcion;
    private Double monto;
    private String moneda;

}
