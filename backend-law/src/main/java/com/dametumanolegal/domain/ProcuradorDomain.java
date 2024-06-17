package com.dametumanolegal.domain;

import com.dametumanolegal.domain.port.input.Procurable;
import com.dametumanolegal.domain.port.output.ProcuradorPersistence;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcuradorDomain implements Procurable {
    private Long id;
    private StaffLegalDomain fkStaffLegal;

    private ProcuradorPersistence procuradorPersistence;
    public ProcuradorDomain(ProcuradorPersistence procuradorPersistence){
        this.procuradorPersistence = procuradorPersistence;
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
