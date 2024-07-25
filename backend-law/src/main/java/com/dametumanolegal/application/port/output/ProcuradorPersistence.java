package com.dametumanolegal.application.port.output;

import com.dametumanolegal.domain.model.*;

import java.util.List;

public interface ProcuradorPersistence {
    void setNotificacion(NotificacionDomain nuevaNotificacion);
    CasoDomain getCasoPorId(Long idCaso);
    void setActuado(ActuadoDomain nuevoActuado);

    List<CasoDomain> getCasos();
    List<CuadernoDomain> getCuadernos();
    List<FiscalDomain> getFiscales();
    List<CasoFiscaliaDomain> getCasosFiscalia();
}
