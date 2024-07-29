package com.dametumanolegal.application.datacarries;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TramiteDataCarrier {
    private Long id;

    private boolean estado;
    private int duraMeses;
    private int numEtapas;
    private String instancia;

    private ClienteDataCarrier fkCliente;
    private AbogadoDataCarrier fkAbogado;
    private HonorarioDataCarrier fkHonor;
    private SubsanacionDataCarrier fkSubsanacion;

}
