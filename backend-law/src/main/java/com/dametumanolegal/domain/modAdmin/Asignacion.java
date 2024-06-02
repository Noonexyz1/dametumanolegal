package com.dametumanolegal.domain.modAdmin;

import com.dametumanolegal.domain.modStaffLegal.StaffLegal;

public class Asignacion {
    private Long idAsignacion;
    private String fechaAsignacion;
    private String fechaSustraccion;
    private boolean isActive;

    private StaffLegal idStaffLegal;
    private Rol idRol;
}
