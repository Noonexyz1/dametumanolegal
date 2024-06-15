package com.dametumanolegal.domain.port.input;

import com.dametumanolegal.domain.CuentaDomain;

public interface Cuentable {
    void crearCuentaParaStaff(CuentaDomain crearCuenta);
    CuentaDomain traerCuentaPorId(Long idCuenta);
    void desactivarCuentaDeStaff(Long idCuenta);
    void modifiPassCuentaDeStaff(CuentaDomain nuevaCuenta);
}
