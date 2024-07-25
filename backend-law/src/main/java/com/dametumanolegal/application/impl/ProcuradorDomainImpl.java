package com.dametumanolegal.application.impl;

import com.dametumanolegal.application.port.output.ProcuradorPersistence;
import com.dametumanolegal.domain.model.*;
import com.dametumanolegal.domain.port.input.Procurable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProcuradorDomainImpl implements Procurable {

    private ProcuradorPersistence procuradorPersistence;

    public ProcuradorDomainImpl(ProcuradorPersistence procuradorPersistence){
        this.procuradorPersistence = procuradorPersistence;
    }


    @Override
    public void registrarNotificacion(NotificacionDomain nuevaNotificacion) {
        procuradorPersistence.setNotificacion(nuevaNotificacion);
    }

    @Override
    public void registrarActuado(ActuadoDomain nuevoActuado, Long idCaso) {
        CasoDomain casoDomain = procuradorPersistence.getCasoPorId(idCaso);
        nuevoActuado.setFkCaso(casoDomain);
        procuradorPersistence.setActuado(nuevoActuado);
    }



    @Override
    public List<CasoDomain> verCasos() {
        return procuradorPersistence.getCasos();
    }

    @Override
    public List<CuadernoDomain> verCuadernos() {
        return procuradorPersistence.getCuadernos();
    }

    @Override
    public List<FiscalDomain> verFiscales() {
        return procuradorPersistence.getFiscales();
    }

    @Override
    public List<CasoFiscaliaDomain> verCasosFiscalia() {
        return procuradorPersistence.getCasosFiscalia();
    }
}
