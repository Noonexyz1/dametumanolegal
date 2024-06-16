package com.dametumanolegal.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FiscaliaDomain {
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String ciudad;
    private String departamento;
    private String pais;
    private String tipo;

}
