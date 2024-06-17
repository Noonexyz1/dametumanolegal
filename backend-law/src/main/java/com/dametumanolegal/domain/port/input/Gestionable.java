package com.dametumanolegal.domain.port.input;

import com.dametumanolegal.domain.CasoDomain;
import com.dametumanolegal.domain.CitaDomain;
import com.dametumanolegal.domain.CuadernoDomain;
import com.dametumanolegal.domain.MemorialDomain;

import java.util.List;

public interface Gestionable {
    void registrarCuaderno(CuadernoDomain cuadernoNuevo);
    void registrarMemorial(MemorialDomain nuevoMemorial, Long idCaso);
    void registrarCita(CitaDomain nuevaCita, Long idCliente, Long idSecre);

    List<CuadernoDomain> verCuadernos();
    List<MemorialDomain> verMemoriales();
    List<CasoDomain> verCasos();
}
