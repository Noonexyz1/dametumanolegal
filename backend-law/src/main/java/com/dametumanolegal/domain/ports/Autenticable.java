package com.dametumanolegal.domain.ports;

import com.dametumanolegal.domain.Cuenta;
import com.dametumanolegal.domain.Sesion;

public interface Autenticable {
    boolean iniciarSesion(Cuenta cuenta);
    void cerrarSesion(Sesion sesion);
    void modificarPassword(Cuenta cuenta);
}
