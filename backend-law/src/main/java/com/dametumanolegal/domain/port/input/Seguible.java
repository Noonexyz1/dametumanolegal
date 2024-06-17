package com.dametumanolegal.domain.port.input;

import com.dametumanolegal.domain.DocumentacionDomain;
import com.dametumanolegal.domain.HonorarioDomain;
import com.dametumanolegal.domain.NotificacionDomain;
import com.dametumanolegal.domain.TramiteDomain;

public interface Seguible {
    TramiteDomain verTramite(Long idTramite);
    DocumentacionDomain verDocumentacionTram(Long idTramite);
    HonorarioDomain verHonorario(Long idTramite);
    NotificacionDomain verNotificacion(Long idCaso);
}
