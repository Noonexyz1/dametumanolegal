package com.dametumanolegal.application.impl;

import com.dametumanolegal.application.datacarries.CasoDataCarrier;
import com.dametumanolegal.application.datacarries.CuadernoDataCarrier;
import com.dametumanolegal.application.datacarries.MemorialDataCarrier;
import com.dametumanolegal.application.port.output.SecretariaPersistence;
import com.dametumanolegal.domain.model.*;
import com.dametumanolegal.domain.port.input.Gestionable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class SecretariaDomainImpl implements Gestionable {

    private SecretariaPersistence secrePersistence;

    public SecretariaDomainImpl(SecretariaPersistence secrePersistence){
        this.secrePersistence = secrePersistence;
    }



    @Override
    public void registrarCuaderno(CuadernoDomain cuadernoNuevo) {

        //TODO hacer el mapeo
        CuadernoDataCarrier cuadernoDataCarrier = new CuadernoDataCarrier();
        secrePersistence.registrarCuaderno(cuadernoDataCarrier);
    }

    @Override
    public void registrarMemorial(MemorialDomain nuevoMemorial, Long idCaso) {
        CasoDataCarrier caso = secrePersistence.findCasoPorId(idCaso);

        //TODO hacer mapeo
        CasoDomain casoDomain = CasoDomain.builder().build();
        nuevoMemorial.setFkCaso(casoDomain);

        //TODO hacer mapeo
        MemorialDataCarrier memorialDataCarrier = new MemorialDataCarrier();
        secrePersistence.registrarMemorial(memorialDataCarrier);
    }

    @Override
    public void registrarCita(CitaDomain nuevaCita, Long idCliente, Long idSecre) {
        //TODO registrar citas
        /*ClienteDomain clienteDomain = secrePersistence.findClientePorId(idCliente);
        SecretariaDomainImpl secretariaDomain = secrePersistence.findSecrePorId(idSecre);
        nuevaCita.setFkCliente(clienteDomain);
        nuevaCita.setFkSecre(secretariaDomain);
        secrePersistence.registrarCita(nuevaCita);*/
    }


    @Override
    public List<CuadernoDomain> verCuadernos() {
        List<CuadernoDataCarrier> cuadernoDataCarrierList = secrePersistence.getListCuaderno();

        //TODO hacer mapeo
        List<CuadernoDomain> cuadernoDomainList = new ArrayList<>();
        return cuadernoDomainList;
    }

    @Override
    public List<MemorialDomain> verMemoriales() {
        List<MemorialDataCarrier> memorialDataCarrierList = secrePersistence.getListMemorial();

        //TODO hacer mapeo
        List<MemorialDomain> memorialDomainList = new ArrayList<>();
        return memorialDomainList;
    }

    @Override
    public List<CasoDomain> verCasos() {
        List<CasoDataCarrier> casoDataCarrierList = secrePersistence.getListCaso();

        //TODO hacer mapeo
        List<CasoDomain> casoDomainList = new ArrayList<>();
        return casoDomainList;
    }
}
