package com.dametumanolegal.domain.port.output;

import com.dametumanolegal.domain.*;

import java.util.List;

public interface SecretariaPersistence {
    void registrarCuaderno(CuadernoDomain cuadernoNuevo);
    void registrarMemorial(MemorialDomain nuevoMemorial);
    CasoDomain findCasoPorId(Long idCaso);
    ClienteDomain findClientePorId(Long idCliente);
    SecretariaDomain findSecrePorId(Long idSecre);
    void registrarCita(CitaDomain nuevaCita);

    List<CuadernoDomain> getListCuaderno();
    List<MemorialDomain> getListMemorial();
    List<CasoDomain> getListCaso();
}
