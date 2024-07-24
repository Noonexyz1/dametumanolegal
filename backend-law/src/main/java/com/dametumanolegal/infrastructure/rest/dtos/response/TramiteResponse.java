package com.dametumanolegal.infrastructure.rest.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TramiteResponse {
    private Long id;

    private boolean estado;
    private int duraMeses;
    private int numEtapas;
    private String instancia;

    private ClienteResponse fkCliente;
    private AbogadoResponse fkAbogado;
    private HonorarioResponse fkHonor;

    private SubsanacionResponse fkSubsanacion;
}
