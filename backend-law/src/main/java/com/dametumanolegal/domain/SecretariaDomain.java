package com.dametumanolegal.domain;

import com.dametumanolegal.domain.port.input.Gestionable;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SecretariaDomain implements Gestionable {
    private Long id;

    private StaffLegalDomain fkStaffLegal;




    @Override
    public void registrarCuaderno(CuadernoDomain cuadernoNuevo) {

    }

    @Override
    public void registrarMemoria(MemorialDomain nuevoMemorial) {

    }

    @Override
    public void registrarCita(CitaDomain nuevaCita) {

    }

    @Override
    public List<CuadernoDomain> verCuadernos() {
        return List.of();
    }

    @Override
    public List<MemorialDomain> verMemoriales() {
        return List.of();
    }

    @Override
    public List<CasoDomain> verCasos() {
        return List.of();
    }
}
