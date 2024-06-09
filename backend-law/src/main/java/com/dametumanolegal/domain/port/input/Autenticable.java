package com.dametumanolegal.domain.port.input;

import com.dametumanolegal.domain.modAdmin.CuentaDomain;
import com.dametumanolegal.domain.modStaffLegal.SesionDomain;

public interface Autenticable {
    SesionDomain iniciarSesion(CuentaDomain cuentaDomain);
    void cerrarSesion(SesionDomain closeSesion);
    void modificarPassword(SesionDomain sesionDomain, CuentaDomain cuentaDomain, String newPass);
}
