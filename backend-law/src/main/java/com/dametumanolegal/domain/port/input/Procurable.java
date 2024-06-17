package com.dametumanolegal.domain.port.input;

import com.dametumanolegal.domain.*;

import java.util.List;

public interface Procurable {
    void registrarNotificacion(NotificacionDomain nuevaNotificacion);
    void registrarActuado(ActuadoDomain nuevoActuado, Long idCaso);

    List<CasoDomain> verCasos();
    List<CuadernoDomain> verCuadernos();
    List<FiscalDomain> verFiscales();
    List<CasoFiscaliaDomain> verCasosFiscalia();
}

