package com.dametumanolegal.domain.port;

import com.dametumanolegal.domain.modAdmin.RolDomain;
import com.dametumanolegal.domain.modStaffLegal.StaffLegalDomain;

import java.util.List;

public interface Rolable {
    void crearRol(RolDomain rolNuevo);
    void traerRolPorId(String idRol);
    void modificarRol(RolDomain rolModificado);
    List<RolDomain> listarRoles();
    void desactivarRol(RolDomain rolDesactivado);
    void asiginarElRol(StaffLegalDomain personal, RolDomain rol);
}
