package com.dametumanolegal.domain.adapter.output;

import com.dametumanolegal.domain.modAdmin.CuentaDomain;
import com.dametumanolegal.domain.modStaffLegal.SesionDomain;
import com.dametumanolegal.domain.modStaffLegal.StaffLegalDomain;
import com.dametumanolegal.domain.port.output.ModStaffLegal;
import com.dametumanolegal.entities.Cuenta;
import com.dametumanolegal.entities.Sesion;
import com.dametumanolegal.repository.CuentaRepository;
import com.dametumanolegal.repository.SesionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.modelmapper.ModelMapper;

import java.util.Optional;

@Component
public class StaffLegalAdapter implements ModStaffLegal {
    @Autowired
    private CuentaRepository cuentaRepository;
    @Autowired
    private SesionRepository sesionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CuentaDomain crear(CuentaDomain cuentaDomain) {
        Cuenta cuenta = new Cuenta();
        cuenta.setCiUsuario(cuentaDomain.getCiUsuario());
        cuenta.setPassUsuario(cuentaDomain.getPassUsuario());

        cuenta = cuentaRepository.save(cuenta);

        cuentaDomain.setCiUsuario(cuenta.getCiUsuario());
        cuentaDomain.setPassUsuario(cuenta.getPassUsuario());
        return cuentaDomain;
    }

    @Override
    public CuentaDomain buscarPorUserYPass(String ci, String pass) {
        Optional<Cuenta> cuenta = cuentaRepository.findByUsuarioAndContrasena(ci, pass);
        if (cuenta.isPresent()) {
            com.dametumanolegal.entities.StaffLegal staffLegal = cuenta.get().getFk();
            StaffLegalDomain staffLegalDomain = modelMapper.map(staffLegal, StaffLegalDomain.class);
            return CuentaDomain.builder()
                    .idCuenta(cuenta.orElseThrow().getIdCuenta())
                    .fk(staffLegalDomain)
                    .ciUsuario(cuenta.orElseThrow().getCiUsuario())
                    .isActive(cuenta.orElseThrow().isActive())
                    .build();
        }
        return null;
    }

    @Override
    public void crearSesion(SesionDomain sesionDomain) {
        Sesion sesion = new Sesion();
        sesion.setEstadoSesion(sesionDomain.isEstadoSesion());
        sesion.setFechaSesion(sesionDomain.getFechaSesion());

        com.dametumanolegal.entities.StaffLegal staffLegal = modelMapper.map(sesionDomain.getFk(), com.dametumanolegal.entities.StaffLegal.class);

        sesion.setIdStaffLegal(staffLegal);
        sesionRepository.save(sesion);
    }

    @Override
    public void actualizar(CuentaDomain cuentaDomain) {
        Cuenta cuenta = modelMapper.map(cuentaDomain, Cuenta.class);
        cuentaRepository.save(cuenta);
    }
}
