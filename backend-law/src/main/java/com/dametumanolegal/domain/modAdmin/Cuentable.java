package com.dametumanolegal.domain.modAdmin;

public interface Cuentable {
    void crearCuentaParaStaff(Cuenta neuvaCuenta);
    void traerCuentaPorId(String idCuentas);
    void desactivarCuentaDeStaff(Cuenta cuentaForChange);
    void modifiPassCuentaDeStaff(Cuenta cuentaForChange);
}
