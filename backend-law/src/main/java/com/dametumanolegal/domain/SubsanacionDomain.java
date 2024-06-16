package com.dametumanolegal.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubsanacionDomain {
    private Long id;
    private int plazoEnDias;
    private String fechaInicio;
    private String fechaLimite;
    private String descripcion;

}

