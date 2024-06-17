package com.dametumanolegal.domain;

import com.dametumanolegal.domain.port.input.Seguible;
import com.dametumanolegal.domain.port.output.ClientePersitence;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDomain implements Seguible {
    private Long id;
    private StaffLegalDomain fkStaffLegal;

    /*@Autowired pero manual*/
    private ClientePersitence clientePersitence;
    public ClienteDomain(ClientePersitence clientePersitence) {
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
