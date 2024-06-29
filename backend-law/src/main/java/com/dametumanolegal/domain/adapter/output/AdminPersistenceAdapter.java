package com.dametumanolegal.domain.adapter.output;

import com.dametumanolegal.domain.CuentaDomain;
import com.dametumanolegal.domain.StaffLegalDomain;
import com.dametumanolegal.domain.port.output.AdminPersistence;
import com.dametumanolegal.entities.Cuenta;
import com.dametumanolegal.repository.CuentaRepository;
import com.dametumanolegal.repository.StaffLegalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

//ESTA CLASE se encarga de transformar ENTIDADES DE DOMINIO a entidades de BD
//Y este debe devolverlo en entidades de BD a ENTIDADES DE DOMINIO

                //ADAPTADOR de SALIDA   //PUERTO de SALIDA de mi DOMAIN
@Component("adminPersistenceAdapter")
public class AdminPersistenceAdapter implements AdminPersistence {

    @Autowired //PUERTO DE ENTRADA a mi SERVICIO para PERSISTENCIA
    private CuentaRepository cuentaRepository;
    @Autowired
    private StaffLegalRepository staffLegalRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void crearCuentaParaStaff(CuentaDomain cuentaDomain) {
        Cuenta cuenta = modelMapper.map(cuentaDomain, Cuenta.class);
        cuentaRepository.save(cuenta);
    }

    @Override
    public CuentaDomain traerCuentaPorID(Long id) {
        Optional<Cuenta> cuenta = cuentaRepository.findById(id);
        if (cuenta.isPresent()) {
            CuentaDomain cuentaDomain = modelMapper.map(cuenta.get(), CuentaDomain.class);
            return cuentaDomain;
        }
        return null;
    }



    @Override
    public StaffLegalDomain traerStaffPorId(Long id) {
        return modelMapper.map(staffLegalRepository.findById(id), StaffLegalDomain.class);
    }
}
