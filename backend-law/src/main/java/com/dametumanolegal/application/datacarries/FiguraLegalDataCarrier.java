package com.dametumanolegal.application.datacarries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FiguraLegalDataCarrier {
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
