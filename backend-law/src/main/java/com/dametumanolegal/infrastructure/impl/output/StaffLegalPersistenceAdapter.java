package com.dametumanolegal.infrastructure.impl.output;

import com.dametumanolegal.domain.model.CuentaDomain;
import com.dametumanolegal.domain.model.SesionDomain;
import com.dametumanolegal.application.port.output.StaffLegalPersistence;
import com.dametumanolegal.infrastructure.persistence.entities.Cuenta;
import com.dametumanolegal.infrastructure.persistence.entities.Sesion;
import com.dametumanolegal.infrastructure.persistence.repository.CuentaRepository;
import com.dametumanolegal.infrastructure.persistence.repository.SesionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.modelmapper.ModelMapper;

import java.util.Optional;

@Component("staffLegalPersistenceAdapter")
public class StaffLegalPersistenceAdapter implements StaffLegalPersistence {
    @Autowired
    private CuentaRepository cuentaRepository;
    @Autowired
    private SesionRepository sesionRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CuentaDomain buscarPorUserYPass(String ci, String pass) {
        Optional<Cuenta> cuenta = cuentaRepository.findByUsuarioAndContrasena(ci, pass);
        return cuenta.map(value -> modelMapper.map(value, CuentaDomain.class)).orElse(null);
    }

    @Override
    public SesionDomain crearSesion(SesionDomain sesionDomain) {
        Sesion sesion = modelMapper.map(sesionDomain, Sesion.class);
        sesion = sesionRepository.save(sesion);
        sesionDomain = modelMapper.map(sesion, SesionDomain.class);
        return sesionDomain;
    }

    @Override
    public void actualizar(CuentaDomain cuentaDomain) {
        Cuenta cuenta = modelMapper.map(cuentaDomain, Cuenta.class);
        cuentaRepository.save(cuenta);
    }
}
