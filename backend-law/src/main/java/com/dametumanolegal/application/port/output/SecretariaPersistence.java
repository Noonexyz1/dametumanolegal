package com.dametumanolegal.application.port.output;

import com.dametumanolegal.application.datacarries.*;
import com.dametumanolegal.domain.model.*;

import java.util.List;

public interface SecretariaPersistence {
    void registrarCuaderno(CuadernoDataCarrier cuadernoNuevo);
    void registrarMemorial(MemorialDataCarrier nuevoMemorial);
    CasoDataCarrier findCasoPorId(Long idCaso);
    ClienteDataCarrier findClientePorId(Long idCliente);
    SecretariaDataCarrier findSecrePorId(Long idSecre);
    void registrarCita(CitaDataCarrier nuevaCita);

    List<CuadernoDataCarrier> getListCuaderno();
    List<MemorialDataCarrier> getListMemorial();
    List<CasoDataCarrier> getListCaso();
}
