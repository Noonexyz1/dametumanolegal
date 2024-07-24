package com.dametumanolegal.domain.port.input;

import com.dametumanolegal.domain.model.CasoDomain;
import com.dametumanolegal.domain.model.CitaDomain;
import com.dametumanolegal.domain.model.CuadernoDomain;
import com.dametumanolegal.domain.model.MemorialDomain;

import java.util.List;

public interface Gestionable {
    void registrarCuaderno(CuadernoDomain cuadernoNuevo);
    void registrarMemorial(MemorialDomain nuevoMemorial, Long idCaso);
    void registrarCita(CitaDomain nuevaCita, Long idCliente, Long idSecre);

    List<CuadernoDomain> verCuadernos();
    List<MemorialDomain> verMemoriales();
    List<CasoDomain> verCasos();
}
