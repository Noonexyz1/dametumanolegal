package com.dametumanolegal.domain;

import com.dametumanolegal.entities.Abogado;
import com.dametumanolegal.entities.Cliente;
import com.dametumanolegal.entities.Honorario;
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

    private Cliente fkCliente;
    private Abogado fkAbogado;
    private Honorario fkHonor;

}
