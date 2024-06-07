package com.dametumanolegal.domain.adapter;

import com.dametumanolegal.domain.modAdmin.CuentaDomain;
import com.dametumanolegal.domain.modStaffLegal.SesionDomain;

public interface ModStaffLegal {
    CuentaDomain crear(CuentaDomain cuenta);
    CuentaDomain buscarPorUserYPass(String ci, String pass);
    void crearSesion(SesionDomain sesionDomain);
    void actualizar(CuentaDomain cuentaDomain);
}
