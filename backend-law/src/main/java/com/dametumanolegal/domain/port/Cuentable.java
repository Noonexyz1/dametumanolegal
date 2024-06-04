package com.dametumanolegal.domain.port;

import com.dametumanolegal.domain.modAdmin.CuentaDomain;

public interface Cuentable {
    void crearCuentaParaStaff(CuentaDomain neuvaCuenta);
    void traerCuentaPorId(String idCuentas);
    void desactivarCuentaDeStaff(CuentaDomain cuentaForChange);
    void modifiPassCuentaDeStaff(CuentaDomain cuentaForChange);
}
