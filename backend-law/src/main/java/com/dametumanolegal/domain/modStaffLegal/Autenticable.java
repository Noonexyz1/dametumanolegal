package com.dametumanolegal.domain.modStaffLegal;

import com.dametumanolegal.domain.modAdmin.Cuenta;

public interface Autenticable {
    boolean iniciarSesion(Cuenta cuenta);
    void cerrarSesion(Sesion sesion);
    void modificarPassword(Cuenta cuenta);
}
