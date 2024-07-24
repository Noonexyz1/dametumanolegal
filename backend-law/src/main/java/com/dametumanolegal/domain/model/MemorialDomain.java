package com.dametumanolegal.domain.model;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemorialDomain {
    private Long id;
    private String titulo;
    private String contenido;
    private String fechaCreacion;

    private CasoDomain fkCaso;
}
