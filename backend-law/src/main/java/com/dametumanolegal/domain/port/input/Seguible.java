package com.dametumanolegal.domain.port.input;

import com.dametumanolegal.domain.model.DocumentacionDomain;
import com.dametumanolegal.domain.model.HonorarioDomain;
import com.dametumanolegal.domain.model.NotificacionDomain;
import com.dametumanolegal.domain.model.TramiteDomain;

public interface Seguible {
    TramiteDomain verTramite(Long idTramite);
    DocumentacionDomain verDocumentacionTram(Long idTramite);
    HonorarioDomain verHonorario(Long idTramite);
    NotificacionDomain verNotificacion(Long idCaso);
}
