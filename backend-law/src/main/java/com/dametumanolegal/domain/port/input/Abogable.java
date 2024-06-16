package com.dametumanolegal.domain.port.input;

import com.dametumanolegal.domain.*;

import java.util.List;

public interface Abogable {
    void registrarCaso(CasoDomain nuevoCaso);
    void registrarMinuta(MinutaDomain nuevaMinuta);
    void registrarHonorario(HonorarioDomain nuevoHonorario);
    void registrarNotificacion(NotificacionDomain nuevaNotificacion);
    void registrarSubsanacion(SubsanacionDomain nuevaSubsanacion);
    void registrarCliente(ClienteDomain nuevoCliente);
    void registrarMemorial(MemorialDomain nuevoMemorial);

    List<JuzgadoDomain> verListaJuzgados();
    List<CasoDomain> verListaCasos();
    List<FiscalDomain> verListaFiscales();
    List<CasoFiscaliaDomain> verListaCasosFiscalia();
    List<CasoJuzgadoDomain> verListaCasosJuzgado();
    List<MemorialDomain> verListaMemoriales();

}
