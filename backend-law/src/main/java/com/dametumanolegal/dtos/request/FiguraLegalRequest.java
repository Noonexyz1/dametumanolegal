package com.dametumanolegal.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FiguraLegalRequest {
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
