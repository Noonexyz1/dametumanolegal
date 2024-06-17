package com.dametumanolegal.domain;

import com.dametumanolegal.domain.port.input.Procurable;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcuradorDomain implements Procurable {
    private Long id;

    private StaffLegalDomain fkStaffLegal;



    @Override
    public void registrarNotificacion(NotificacionDomain nuevaNotificacion) {

    }

    @Override
    public void registrarActuado(ActuadoDomain nuevoActuado) {

    }

    @Override
    public List<CasoDomain> verCasos() {
        return List.of();
    }

    @Override
    public List<CuadernoDomain> verCuadernos() {
        return List.of();
    }

    @Override
    public List<FiscalDomain> verFiscales() {
        return List.of();
    }

    @Override
    public List<CasoFiscaliaDomain> verCasosFiscalia() {
        return List.of();
    }
}
