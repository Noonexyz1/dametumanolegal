package com.dametumanolegal.domain.adapter;

import com.dametumanolegal.domain.modAdmin.CuentaDomain;
import com.dametumanolegal.entities.Cuenta;
import com.dametumanolegal.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersistenciaCuentaAdapter implements PersistenciaCuenta {
    @Autowired
    private CuentaRepository repository;

    @Override
    public CuentaDomain crear(CuentaDomain cuentaDomain) {
        Cuenta cuenta = new Cuenta();
        cuenta.setCiUsuario(cuentaDomain.getCiUsuario());
        cuenta.setPassUsuario(cuentaDomain.getPassUsuario());

        cuenta = repository.save(cuenta);

        cuentaDomain.setCiUsuario(cuenta.getCiUsuario());
        cuentaDomain.setPassUsuario(cuenta.getPassUsuario());
        return cuentaDomain;
    }

    @Override
    public void leer() {

    }

    @Override
    public void actualizar() {

    }

    @Override
    public void eliminar() {

    }
}
