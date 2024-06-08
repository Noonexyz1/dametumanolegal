package com.dametumanolegal.domain.port.output;

import com.dametumanolegal.domain.modAdmin.AsignacionDomain;
import com.dametumanolegal.domain.modAdmin.CuentaDomain;
import com.dametumanolegal.domain.modAdmin.RolDomain;
import com.dametumanolegal.domain.modStaffLegal.StaffLegalDomain;

import java.util.List;

public interface ModAdmin {
    void crearCuentaParaStaff(CuentaDomain cuentaDomain);
    CuentaDomain traerCuentaPorID(Long id);

    void crearRol(RolDomain rolNuevo);
    RolDomain traerRolPorId(Long id);
    void modificarRol(RolDomain rolModificado);
    List<RolDomain> listarRoles();
    void desactivarRol(RolDomain rolDesactivado);
    void asiginarElRol(AsignacionDomain asignacion);

    StaffLegalDomain traerStaffPorId(Long id);
}
