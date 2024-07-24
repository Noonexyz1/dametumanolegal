package com.dametumanolegal.domain.model;

import com.dametumanolegal.domain.port.input.Seguible;
import com.dametumanolegal.domain.port.output.ClientePersitence;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDomain extends StaffLegalDomain implements Seguible {
    private Long idCliente;

    /*@Autowired pero manual*/
    private ClientePersitence clientePersitence;
    public ClienteDomain(ClientePersitence clientePersitence) {
        this.clientePersitence = clientePersitence;
    }

    public ClienteDomain(Long idFiguraLegal, String nombres, String apellidos, String ci, String direccion, String telefono, String email, String rol, String fechaNacimiento, String genero, String fechaRegistro, boolean isActive, Long idStaffLegal, Long idCliente){
        super(idFiguraLegal, nombres, apellidos, ci, direccion, telefono, email, rol, fechaNacimiento, genero, fechaRegistro, isActive, idStaffLegal);
        this.idCliente = idCliente;
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
