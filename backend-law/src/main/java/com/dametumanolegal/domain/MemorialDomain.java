package com.dametumanolegal.domain;


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
