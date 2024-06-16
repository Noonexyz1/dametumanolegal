package com.dametumanolegal.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FiguraLegalDomain {
    private Long id;
    private String nombres;
    private String apellidos;
    private String ci;

    private String direccion;
    private String telefono;
    private String email;
    private String rol;
    private String fechaNacimiento;
    private String genero;
    private String fechaRegistro;

    private boolean isActive;
}
