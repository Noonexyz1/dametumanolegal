package com.dametumanolegal.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TramiteDomain {
    private Long id;

    private boolean estado;
    private int duraMeses;
    private int numEtapas;
    private String instancia;

    private ClienteDomain fkCliente;
    private AbogadoDomain fkAbogado;
    private HonorarioDomain fkHonor;
    private SubsanacionDomain fkSubsanacion;

}
