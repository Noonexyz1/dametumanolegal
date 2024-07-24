package com.dametumanolegal.domain.port.output;

import com.dametumanolegal.domain.model.DocumentacionDomain;
import com.dametumanolegal.domain.model.HonorarioDomain;
import com.dametumanolegal.domain.model.NotificacionDomain;
import com.dametumanolegal.domain.model.TramiteDomain;

public interface ClientePersitence {
    TramiteDomain verProcTram(Long idTramite);
    DocumentacionDomain verDocumentacionTram(Long idTramite);
    HonorarioDomain getHonorario(Long idTramite);
    NotificacionDomain getNotificacion(Long idCaso);
}
