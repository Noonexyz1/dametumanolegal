package com.dametumanolegal.domain.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CitaDomain {
    private Long id;
    private String fechaCita;
    private int duracion; // Duración en minutos
    private String motivo;
    private String ubicacion;
    private String estado;
    private String notas;
    private String fechaCreacion;
    private String creador;

    private SecretariaDomain fkSecre;
    private ClienteDomain fkCliente;
}
