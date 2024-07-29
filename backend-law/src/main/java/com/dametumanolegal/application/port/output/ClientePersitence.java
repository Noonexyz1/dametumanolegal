package com.dametumanolegal.application.port.output;

import com.dametumanolegal.application.datacarries.DocumentacionDataCarrier;
import com.dametumanolegal.application.datacarries.HonorarioDataCarrier;
import com.dametumanolegal.application.datacarries.NotificacionDataCarrier;
import com.dametumanolegal.application.datacarries.TramiteDataCarrier;
import com.dametumanolegal.domain.model.DocumentacionDomain;
import com.dametumanolegal.domain.model.HonorarioDomain;
import com.dametumanolegal.domain.model.NotificacionDomain;
import com.dametumanolegal.domain.model.TramiteDomain;

public interface ClientePersitence {
    TramiteDataCarrier verProcTram(Long idTramite);
    DocumentacionDataCarrier verDocumentacionTram(Long idTramite);
    HonorarioDataCarrier getHonorario(Long idTramite);
    NotificacionDataCarrier getNotificacion(Long idCaso);
}
