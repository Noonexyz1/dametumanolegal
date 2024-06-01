package com.dametumanolegal.domain.ports;

import com.dametumanolegal.domain.Cuenta;

public interface Cuentable {
    void crearCuenta(Cuenta neuvaCuenta);
    void traerCuentaPorId(String idCuentas);
    void desactivarCuenta(Cuenta cuentaDesactivada);
}
