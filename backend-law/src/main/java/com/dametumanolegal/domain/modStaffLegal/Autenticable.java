package com.dametumanolegal.domain.modStaffLegal;

public interface Autenticable {
    boolean iniciarSesion(Cuenta cuenta);
    void cerrarSesion(Sesion sesion);
    void modificarPassword(Cuenta cuenta);
}
