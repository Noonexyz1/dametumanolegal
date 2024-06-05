package com.dametumanolegal.domain.modAdmin;

import java.util.List;

public class RolDomain {
    private Long idRol;
    private String nombreRol;
    private String descripcionRol;
    private boolean isActive;

    private List<AsignacionDomain> listaAsginaciones;
}
