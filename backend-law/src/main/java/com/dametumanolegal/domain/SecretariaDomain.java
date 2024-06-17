package com.dametumanolegal.domain;

import com.dametumanolegal.domain.port.input.Gestionable;
import com.dametumanolegal.domain.port.output.SecretariaPersistence;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SecretariaDomain implements Gestionable {
    private Long id;

    private StaffLegalDomain fkStaffLegal;

    private SecretariaPersistence secrePersistence;
    public SecretariaDomain(SecretariaPersistence secrePersistence){
        this.secrePersistence = secrePersistence;
    }


    @Override
    public void registrarCuaderno(CuadernoDomain cuadernoNuevo) {
        secrePersistence.registrarCuaderno(cuadernoNuevo);
    }

    @Override
    public void registrarMemorial(MemorialDomain nuevoMemorial, Long idCaso) {
        CasoDomain caso = secrePersistence.findCasoPorId(idCaso);
        nuevoMemorial.setFkCaso(caso);
        secrePersistence.registrarMemorial(nuevoMemorial);
    }

    @Override
    public void registrarCita(CitaDomain nuevaCita, Long idCliente, Long idSecre) {
        ClienteDomain clienteDomain = secrePersistence.findClientePorId(idCliente);
        SecretariaDomain secretariaDomain = secrePersistence.findSecrePorId(idSecre);
        nuevaCita.setFkCliente(clienteDomain);
        nuevaCita.setFkSecre(secretariaDomain);
        secrePersistence.registrarCita(nuevaCita);
    }


    @Override
    public List<CuadernoDomain> verCuadernos() {
        return secrePersistence.getListCuaderno();
    }

    @Override
    public List<MemorialDomain> verMemoriales() {
        return secrePersistence.getListMemorial();
    }

    @Override
    public List<CasoDomain> verCasos() {
        return secrePersistence.getListCaso();
    }
}
