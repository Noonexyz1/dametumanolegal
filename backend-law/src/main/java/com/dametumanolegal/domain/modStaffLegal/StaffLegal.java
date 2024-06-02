package com.dametumanolegal.domain.modStaffLegal;

import com.dametumanolegal.domain.modAdmin.Abogado;
import com.dametumanolegal.domain.modAdmin.Cuenta;
import com.dametumanolegal.domain.modAdmin.Asignacion;

import java.util.List;

public class StaffLegal {
    private Long id;
    private String nombres;
    private String apellidos;
    private String ci;
    private boolean isActive;

    private List<Abogado> listaAbogados;
    private List<Cuenta> listaCuentas;
    private List<Sesion> listaSesiones;
    private List<Asignacion> listaAsginaciones;
}
