package com.dametumanolegal.domain;

import com.dametumanolegal.domain.port.input.Procurable;
import com.dametumanolegal.domain.port.output.ProcuradorPersistence;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcuradorDomain extends StaffLegalDomain implements Procurable {
    private Long idProcurador;

    private ProcuradorPersistence procuradorPersistence;
    public ProcuradorDomain(ProcuradorPersistence procuradorPersistence){
        this.procuradorPersistence = procuradorPersistence;
    }

    public ProcuradorDomain(Long id, String nombres, String apellidos, String ci, String direccion, String telefono, String email, String rol, String fechaNacimiento, String genero, String fechaRegistro, boolean isActive, Long idProcurador){
        super(id, nombres, apellidos, ci, direccion, telefono, email, rol, fechaNacimiento, genero, fechaRegistro, isActive);
        this.idProcurador = idProcurador;
    }

    @Override
    public void registrarNotificacion(NotificacionDomain nuevaNotificacion) {
        procuradorPersistence.setNotificacion(nuevaNotificacion);
    }

    @Override
    public void registrarActuado(ActuadoDomain nuevoActuado, Long idCaso) {
        CasoDomain casoDomain = procuradorPersistence.getCasoPorId(idCaso);
        nuevoActuado.setFkCaso(casoDomain);
        procuradorPersistence.setActuado(nuevoActuado);
    }



    @Override
    public List<CasoDomain> verCasos() {
        return procuradorPersistence.getCasos();
    }

    @Override
    public List<CuadernoDomain> verCuadernos() {
        return procuradorPersistence.getCuadernos();
    }

    @Override
    public List<FiscalDomain> verFiscales() {
        return procuradorPersistence.getFiscales();
    }

    @Override
    public List<CasoFiscaliaDomain> verCasosFiscalia() {
        return procuradorPersistence.getCasosFiscalia();
    }
}
