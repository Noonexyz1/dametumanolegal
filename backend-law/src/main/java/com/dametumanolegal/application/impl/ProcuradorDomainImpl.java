package com.dametumanolegal.application.impl;

import com.dametumanolegal.application.datacarries.*;
import com.dametumanolegal.application.port.output.ProcuradorPersistence;
import com.dametumanolegal.domain.model.*;
import com.dametumanolegal.domain.port.input.Procurable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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
        
        //TODO hacer el mapeo correspondiente
        NotificacionDataCarrier notificacionDataCarrier = new NotificacionDataCarrier();

        procuradorPersistence.setNotificacion(notificacionDataCarrier);
    }

    @Override
    public void registrarActuado(ActuadoDomain nuevoActuado, Long idCaso) {
        CasoDataCarrier casoDataCarrier = procuradorPersistence.getCasoPorId(idCaso);

        //TODO hacer los mapeos
        CasoDomain casoDomain = CasoDomain.builder()
                .build();

        nuevoActuado.setFkCaso(casoDomain);

        //TODO hacer los mapeos
        ActuadoDataCarrier actuadoDataCarrier = new ActuadoDataCarrier();

        procuradorPersistence.setActuado(actuadoDataCarrier);
    }



    @Override
    public List<CasoDomain> verCasos() {
        List<CasoDataCarrier> listCasoDataCarrier = procuradorPersistence.getCasos();

        //TODO hacer el mapeo
        List<CasoDomain> casoDomainList = new ArrayList<>();
        return casoDomainList;
    }

    @Override
    public List<CuadernoDomain> verCuadernos() {
        List<CuadernoDataCarrier> cuadernoDataCarrierList = procuradorPersistence.getCuadernos();

        //TODO hacer el mapeo
        List<CuadernoDomain> cuadernoDomainList = new ArrayList<>();
        return cuadernoDomainList;
    }

    @Override
    public List<FiscalDomain> verFiscales() {
        List<FiscalDataCarrier> fiscalDataCarrierList = procuradorPersistence.getFiscales();

        //TODO hacer el mapeo
        List<FiscalDomain> fiscalDomainList = new ArrayList<>();
        return fiscalDomainList;
    }

    @Override
    public List<CasoFiscaliaDomain> verCasosFiscalia() {
        List<CasoFiscaliaDataCarrier> casoFiscaliaDataCarrierList = procuradorPersistence.getCasosFiscalia();

        //TODO hacer el mapeo
        List<CasoFiscaliaDomain> casoFiscaliaDomainList = new ArrayList<>();
        return casoFiscaliaDomainList;
    }
}
