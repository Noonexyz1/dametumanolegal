package com.dametumanolegal.domain.port.output;

import com.dametumanolegal.domain.DocumentacionDomain;
import com.dametumanolegal.domain.HonorarioDomain;
import com.dametumanolegal.domain.NotificacionDomain;
import com.dametumanolegal.domain.TramiteDomain;

public interface ClientePersitence {
    TramiteDomain verProcTram(Long idTramite);
    DocumentacionDomain verDocumentacionTram(Long idTramite);
    HonorarioDomain getHonorario(Long idTramite);
    NotificacionDomain getNotificacion(Long idCaso);
}
