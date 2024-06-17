package com.dametumanolegal.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrarCitaRequest {
    private CitaRequest citaRequest;
    private Long idCliente;
    private Long idSecretaria;
}
