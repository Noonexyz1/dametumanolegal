package com.dametumanolegal.domain.port.input;

import com.dametumanolegal.domain.CuentaDomain;

public interface Cuentable {
    void crearCuentaParaStaff(Long idStaffLegal);
    CuentaDomain traerCuentaPorId(Long idCuenta);
    void desactivarCuentaDeStaff(Long idCuenta);
    void modifiPassCuentaDeStaff(CuentaDomain cuentaAdmin, Long idCuenta, String newPass);
}
