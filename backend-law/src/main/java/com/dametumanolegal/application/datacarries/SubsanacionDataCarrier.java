package com.dametumanolegal.application.datacarries;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubsanacionDataCarrier {
    private Long id;
    private int plazoEnDias;
    private String fechaInicio;
    private String fechaLimite;
    private String descripcion;

}

