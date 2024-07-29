package com.dametumanolegal.application.datacarries;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemorialDataCarrier {
    private Long id;
    private String titulo;
    private String contenido;
    private String fechaCreacion;

    private CasoDataCarrier fkCaso;
}
