package com.dametumanolegal.application.impl;

import com.dametumanolegal.application.port.output.ClientePersitence;
import com.dametumanolegal.domain.model.*;
import com.dametumanolegal.domain.port.input.Seguible;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDomainImpl implements Seguible {

    private ClientePersitence clientePersitence;

    public ClienteDomainImpl(ClientePersitence clientePersitence) {
        this.clientePersitence = clientePersitence;
    }

    @Override
    public TramiteDomain verTramite(Long idTramite) {
        TramiteDomain tram = clientePersitence.verProcTram(idTramite);
        return tram;
    }
    @Override
    public DocumentacionDomain verDocumentacionTram(Long idTramite) {
        return clientePersitence.verDocumentacionTram(idTramite);
    }
    @Override
    public HonorarioDomain verHonorario(Long idTramite) {
        return clientePersitence.getHonorario(idTramite);
    }
    @Override
    public NotificacionDomain verNotificacion(Long idCaso) {
        return clientePersitence.getNotificacion(idCaso);
    }
}
