package com.dametumanolegal.domain.port.output;

import com.dametumanolegal.domain.CuentaDomain;
import com.dametumanolegal.domain.SesionDomain;

public interface StaffLegalPersistence {
    CuentaDomain buscarPorUserYPass(String ci, String pass);
    SesionDomain crearSesion(SesionDomain sesionDomain);
    void actualizar(CuentaDomain cuentaDomain);
}
