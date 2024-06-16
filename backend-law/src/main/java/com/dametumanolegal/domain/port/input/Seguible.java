package com.dametumanolegal.domain.port.input;

import com.dametumanolegal.domain.DocumentacionDomain;
import com.dametumanolegal.domain.HonorarioDomain;
import com.dametumanolegal.domain.NotificacionDomain;
import com.dametumanolegal.domain.TramiteDomain;

public interface Seguible {
    TramiteDomain verProcesoTramite(Long idTramite);
    DocumentacionDomain verDocumentacionProcTram(Long idTramite);
    HonorarioDomain verHonorarios(Long idTramite);
    NotificacionDomain verNotificaciones(Long idCaso);
}
