package com.dametumanolegal.application.port.output;

import com.dametumanolegal.application.datacarries.*;
import com.dametumanolegal.domain.model.*;

import java.util.List;

public interface ProcuradorPersistence {
    void setNotificacion(NotificacionDataCarrier nuevaNotificacion);
    CasoDataCarrier getCasoPorId(Long idCaso);
    void setActuado(ActuadoDataCarrier nuevoActuado);

    List<CasoDataCarrier> getCasos();
    List<CuadernoDataCarrier> getCuadernos();
    List<FiscalDataCarrier> getFiscales();
    List<CasoFiscaliaDataCarrier> getCasosFiscalia();
}
