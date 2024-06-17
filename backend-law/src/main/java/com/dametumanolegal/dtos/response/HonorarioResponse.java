package com.dametumanolegal.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HonorarioResponse {
    private Long id;
    private String tipoServicio;
    private String descripcion;
    private Double monto;
    private String moneda;
}
