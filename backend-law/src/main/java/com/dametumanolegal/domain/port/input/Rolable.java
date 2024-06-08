package com.dametumanolegal.domain.port.input;

import com.dametumanolegal.domain.modAdmin.RolDomain;

import java.util.List;

public interface Rolable {
    void crearRol(RolDomain rolNuevo);
    RolDomain traerRolPorId(Long id);
    void modificarRol(RolDomain rolModificado);
    List<RolDomain> listarRoles();
    void desactivarRol(RolDomain rolDesactivado);
    void asiginarElRol(Long idPersonal, Long idRol);
}
