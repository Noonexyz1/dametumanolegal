package com.dametumanolegal.domain.adapter;

import com.dametumanolegal.domain.modAdmin.CuentaDomain;
import com.dametumanolegal.domain.modStaffLegal.SesionDomain;
import com.dametumanolegal.domain.modStaffLegal.StaffLegalDomain;
import com.dametumanolegal.entities.Cuenta;
import com.dametumanolegal.entities.Sesion;
import com.dametumanolegal.entities.StaffLegal;
import com.dametumanolegal.repository.CuentaRepository;
import com.dametumanolegal.repository.SesionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.modelmapper.ModelMapper;

import java.util.Optional;

@Component
public class PersistenciaStaffLegal implements PersistenciaModStaffLegal {
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
            StaffLegal staffLegal = cuenta.get().getIdStaffLegal();
            StaffLegalDomain staffLegalDomain = modelMapper.map(staffLegal, StaffLegalDomain.class);
            return CuentaDomain.builder()
                    .idUsuario(cuenta.orElseThrow().getIdUsuario())
                    .idStaffLegal(staffLegalDomain)
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

        StaffLegal staffLegal = modelMapper.map(sesionDomain.getIdStaffLegal(), StaffLegal.class);

        sesion.setIdStaffLegal(staffLegal);
        sesionRepository.save(sesion);
    }

    @Override
    public void actualizar(CuentaDomain cuentaDomain) {
        Cuenta cuenta = modelMapper.map(cuentaDomain, Cuenta.class);
        cuentaRepository.save(cuenta);
    }

    @Override
    public void leer() {

    }

    @Override
    public void eliminar() {

    }
}
