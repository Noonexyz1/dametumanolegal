package com.dametumanolegal.infrastructure.rest.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubsanacionResponse {
    private Long id;
    private int plazoEnDias;
    private String fechaInicio;
    private String fechaLimite;
    private String descripcion;

}

