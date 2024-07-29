package com.dametumanolegal.application.datacarries;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HonorarioDataCarrier {
    private Long id;
    private String tipoServicio;
    private String descripcion;
    private Double monto;
    private String moneda;

}
