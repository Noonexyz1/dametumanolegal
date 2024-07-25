package com.dametumanolegal.application.port.output;

import com.dametumanolegal.domain.model.CuentaDomain;
import com.dametumanolegal.domain.model.SesionDomain;

public interface StaffLegalPersistence {
    CuentaDomain buscarPorUserYPass(String ci, String pass);
    SesionDomain crearSesion(SesionDomain sesionDomain);
    void actualizar(CuentaDomain cuentaDomain);
}
