package com.dametumanolegal.domain.ports;

import com.dametumanolegal.domain.Cuenta;

public interface Cuentable {
    void crearCuentaParaStaff(Cuenta neuvaCuenta);
    void traerCuentaPorId(String idCuentas);
    void desactivarCuentaDeStaff(Cuenta cuentaForChange);
    void modifiPassCuentaDeStaff(Cuenta cuentaForChange);
}
