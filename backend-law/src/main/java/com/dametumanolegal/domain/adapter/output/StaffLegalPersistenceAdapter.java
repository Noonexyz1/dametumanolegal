package com.dametumanolegal.domain.adapter.output;

import com.dametumanolegal.domain.CuentaDomain;
import com.dametumanolegal.domain.SesionDomain;
import com.dametumanolegal.domain.port.output.StaffLegalPersistence;
import com.dametumanolegal.entities.Cuenta;
import com.dametumanolegal.entities.Sesion;
import com.dametumanolegal.repository.CuentaRepository;
import com.dametumanolegal.repository.SesionRepository;
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
