package com.dametumanolegal.application.datacarries;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CitaDataCarrier {
    private Long id;
    private String fechaCita;
    private int duracion; // Duración en minutos
    private String motivo;
    private String ubicacion;
    private String estado;
    private String notas;
    private String fechaCreacion;
    private String creador;

    private SecretariaDataCarrier fkSecre;
    private ClienteDataCarrier fkCliente;
}
