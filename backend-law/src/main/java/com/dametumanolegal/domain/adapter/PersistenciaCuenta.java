package com.dametumanolegal.domain.adapter;

import com.dametumanolegal.domain.modAdmin.CuentaDomain;
import com.dametumanolegal.entities.Cuenta;

public interface PersistenciaCuenta {
    CuentaDomain crear(CuentaDomain cuenta);
    void leer();
    void actualizar();
    void eliminar();
}
