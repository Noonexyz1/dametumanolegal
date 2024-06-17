package com.dametumanolegal.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemorialResponse {
    private Long id;
    private String titulo;
    private String contenido;
    private String fechaCreacion;

    private CasoResponse fkCaso;
}
