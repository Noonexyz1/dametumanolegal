package com.dametumanolegal.domain.port.output;

import com.dametumanolegal.domain.CuentaDomain;
import com.dametumanolegal.domain.SesionDomain;

public interface ModStaffLegal {
    CuentaDomain crear(CuentaDomain cuenta);
    CuentaDomain buscarPorUserYPass(String ci, String pass);
    SesionDomain crearSesion(SesionDomain sesionDomain);
    void actualizar(CuentaDomain cuentaDomain);
}
