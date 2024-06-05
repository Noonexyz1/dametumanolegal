package com.dametumanolegal.domain.modAdmin;

import com.dametumanolegal.domain.modStaffLegal.StaffLegalDomain;

public class AsignacionDomain {
    private Long idAsignacion;
    private String fechaAsignacion;
    private String fechaSustraccion;
    private boolean isActive;

    private StaffLegalDomain idStaffLegal;
    private RolDomain idRol;
}
