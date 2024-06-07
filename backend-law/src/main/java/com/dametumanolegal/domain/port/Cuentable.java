package com.dametumanolegal.domain.port;

import com.dametumanolegal.request.CuentaRequest;
import com.dametumanolegal.response.CreateCuentaResponse;

public interface Cuentable {
    void crearCuentaParaStaff(CuentaRequest crearCuenta);
    CreateCuentaResponse traerCuentaPorId(Long idCuenta);
    void desactivarCuentaDeStaff(Long idCuenta);
    void modifiPassCuentaDeStaff(CuentaRequest neuvaCuenta);
}
