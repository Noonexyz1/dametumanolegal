package com.dametumanolegal.dtos.response;

import com.dametumanolegal.domain.AbogadoDomain;
import com.dametumanolegal.domain.ClienteDomain;
import com.dametumanolegal.domain.HonorarioDomain;
import com.dametumanolegal.domain.SubsanacionDomain;
import com.dametumanolegal.entities.Abogado;
import com.dametumanolegal.entities.Cliente;
import com.dametumanolegal.entities.Honorario;
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

    private ClienteDomain fkCliente;
    private AbogadoDomain fkAbogado;
    private HonorarioDomain fkHonor;
    private SubsanacionDomain fkSubsanacion;
}
