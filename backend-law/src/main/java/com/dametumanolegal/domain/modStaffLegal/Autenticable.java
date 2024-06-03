package com.dametumanolegal.domain.modStaffLegal;

import com.dametumanolegal.domain.modAdmin.Cuenta;

public interface Autenticable {
    boolean iniciarSesion(Cuenta cuenta);
    boolean cerrarSesion(Sesion sesion);
    boolean modificarPassword(Cuenta cuenta);
}
