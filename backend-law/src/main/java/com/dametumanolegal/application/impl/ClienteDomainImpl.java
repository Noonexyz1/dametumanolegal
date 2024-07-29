package com.dametumanolegal.application.impl;

import com.dametumanolegal.application.datacarries.DocumentacionDataCarrier;
import com.dametumanolegal.application.datacarries.HonorarioDataCarrier;
import com.dametumanolegal.application.datacarries.NotificacionDataCarrier;
import com.dametumanolegal.application.datacarries.TramiteDataCarrier;
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
        TramiteDataCarrier tram = clientePersitence.verProcTram(idTramite);

        //TODO hacer el mapeo correspondiente
        TramiteDomain tramiteDomain = TramiteDomain.builder()
                .build();

        return tramiteDomain;
    }

    @Override
    public DocumentacionDomain verDocumentacionTram(Long idTramite) {
        DocumentacionDataCarrier documentDataCarrier = clientePersitence.verDocumentacionTram(idTramite);

        //TODO hacer los mapeos correspondientes
        DocumentacionDomain documentacionDomain = DocumentacionDomain.builder()
                .build();

        return documentacionDomain;
    }

    @Override
    public HonorarioDomain verHonorario(Long idTramite) {
        HonorarioDataCarrier honorarioDataCarrier = clientePersitence.getHonorario(idTramite);

        //TODO  hacer el mapeo correspondiente
        HonorarioDomain honorarioDomain = HonorarioDomain.builder()
                .build();

        return honorarioDomain;
    }

    @Override
    public NotificacionDomain verNotificacion(Long idCaso) {
        NotificacionDataCarrier notificacionDataCarrier = clientePersitence.getNotificacion(idCaso);

        //TODO hacer los mapeos
        NotificacionDomain notificacionDomain = NotificacionDomain.builder()
                .build();

        return notificacionDomain;
    }
}
