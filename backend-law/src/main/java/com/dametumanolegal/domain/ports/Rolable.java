package com.dametumanolegal.domain.ports;

import com.dametumanolegal.domain.Rol;
import com.dametumanolegal.domain.StaffLegal;

import java.util.List;

public interface Rolable {
    void crearRol(Rol rolNuevo);
    void traerRolPorId(String idRol);
    void modificarRol(Rol rolModificado);
    List<Rol> listarRoles();
    void desactivarRol(Rol rolDesactivado);
    void asiginarElRol(StaffLegal personal, Rol rol);
}
